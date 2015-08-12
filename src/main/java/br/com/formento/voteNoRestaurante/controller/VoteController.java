package br.com.formento.voteNoRestaurante.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.formento.voteNoRestaurante.controller.form.FormChoiceRestaurant;
import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.Ranking;
import br.com.formento.voteNoRestaurante.model.RestaurantIcon;
import br.com.formento.voteNoRestaurante.service.CategoryRestaurantService;
import br.com.formento.voteNoRestaurante.service.ComputationVoteService;
import br.com.formento.voteNoRestaurante.service.RestaurantIconService;
import br.com.formento.voteNoRestaurante.service.RestaurantService;
import br.com.formento.voteNoRestaurante.util.ServletUtils;

@Controller
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private CategoryRestaurantService categoryRestaurantService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private RestaurantIconService restaurantIconService;

	@Autowired
	private ComputationVoteService computationVoteService;

	@RequestMapping(path = "/listCategoryRestaurantByOrder", method = RequestMethod.GET)
	public String listCategoryRestaurantByOrder(@RequestParam(value = "order", required = false, defaultValue = "0") int order,
			@RequestParam(value = "idRestaurantList", required = false) List<Long> idRestaurantList, Model model, RedirectAttributes redirectAttrs) {
		CategoryRestaurant categoryRestaurant = categoryRestaurantService.getNextByOrder(order);

		if (categoryRestaurant == null) {
			redirectAttrs.addAttribute("idRestaurantList", idRestaurantList);
			return "redirect:voteForm/{idRestaurantList}";
		} else {
			FormChoiceRestaurant formChoiceRestaurant = restaurantService.getFormChoiceRestaurant(categoryRestaurant);

			model.addAttribute("formChoiceRestaurant", formChoiceRestaurant);

			return "vote/list_category_restaurant_by_order";
		}
	}

	@RequestMapping(path = "/voteForm/{idRestaurantList}", method = RequestMethod.GET)
	public ModelAndView voteForm(@PathVariable(value = "idRestaurantList") List<Long> idRestaurantList, Model model) {
		ComputationVote computationVote = categoryRestaurantService.getComputationVote(idRestaurantList);

		return new ModelAndView("vote/send_votes", "computationVote", computationVote);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("computationVote") ComputationVote computationVote, HttpServletRequest httpServletRequest) {
		ServletUtils servletUtils = new ServletUtils(httpServletRequest);

		String urlBase = servletUtils.getUrlBase();
		computationVoteService.computingVote(computationVote, urlBase);

		return new ModelAndView("vote/saved", "computationVote", computationVote);
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView confirm(Long id, Model model) {
		Ranking ranking = computationVoteService.confirmById(id);

		return new ModelAndView("vote/show_ranking", "ranking", ranking);
	}

	@RequestMapping(value = "/showRestaurantIcon/{idRestaurant}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> showRestaurantIcon(@PathVariable Long idRestaurant, Model model) {
		RestaurantIcon restaurantIcon = restaurantIconService.getEntityById(idRestaurant);
		if (restaurantIcon != null) {
			byte[] iconBytes = restaurantIcon.getIcon();
			InputStream iconInputStream = new ByteArrayInputStream(iconBytes);

			return ResponseEntity.ok().contentLength(iconBytes.length).contentType(MediaType.parseMediaType("image/png"))
					.body(new InputStreamResource(iconInputStream));
		} else
			// refatorar para retornar uma imagem padrão caso não exista
			return null;
	}

}