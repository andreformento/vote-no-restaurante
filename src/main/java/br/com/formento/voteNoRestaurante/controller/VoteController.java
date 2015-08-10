package br.com.formento.voteNoRestaurante.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.formento.voteNoRestaurante.model.CategoryRestaurant;
import br.com.formento.voteNoRestaurante.model.ComputationVote;
import br.com.formento.voteNoRestaurante.model.FormChoiceRestaurant;
import br.com.formento.voteNoRestaurante.model.Restaurant;
import br.com.formento.voteNoRestaurante.model.RestaurantIcon;
import br.com.formento.voteNoRestaurante.service.CategoryRestaurantService;
import br.com.formento.voteNoRestaurante.service.RestaurantIconService;
import br.com.formento.voteNoRestaurante.service.RestaurantService;

@Controller
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private CategoryRestaurantService categoryRestaurantService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private RestaurantIconService restaurantIconService;

//	@RequestMapping(path = "/listCategoryRestaurantByOrder", method = RequestMethod.GET)
//	public String listCategoryRestaurantByOrder(int order, Model model) {
//		CategoryRestaurant categoryRestaurant = categoryRestaurantService.getNextByOrder(order);
//
//		if (categoryRestaurant == null) {
//			// TODO redirecionar para abrir uma pagina nova (redirect)
//			return "vote/send_votes";
//		} else {
//			List<Restaurant> restaurantList = restaurantService.getEntitiesByCategory(categoryRestaurant);
//
//			model.addAttribute("categoryRestaurant", categoryRestaurant);
//			model.addAttribute("restaurantList", restaurantList);
//
//			return "vote/list_category_restaurant_by_order";
//		}
//	}
	
	private void configurePage(Model model,int order ){
		CategoryRestaurant categoryRestaurant = categoryRestaurantService.getNextByOrder(order);
		List<Restaurant> restaurantList = restaurantService.getEntitiesByCategory(categoryRestaurant);
		model.addAttribute("categoryRestaurant", categoryRestaurant);
		model.addAttribute("restaurantList", restaurantList);
	}
	
	@RequestMapping(path = "/listCategoryRestaurantByOrder", method = RequestMethod.GET)
	public ModelAndView listCategoryRestaurantByOrder(Model model) {
		configurePage(model, 0);
		
		FormChoiceRestaurant formChoiceRestaurant = new FormChoiceRestaurant();

		return new ModelAndView("vote/list_category_restaurant_by_order", "formChoiceRestaurant", formChoiceRestaurant);
	}
	
	@RequestMapping(value = "/nextVote", method = RequestMethod.POST)
    public ModelAndView nextVote(@ModelAttribute("computationVoteForm") ComputationVote computationVote,int order, Model model) {
		configurePage(model, order);
		
//        System.out.println(contactForm);
//        System.out.println(contactForm.getContacts());
//        List<Contact> contacts = contactForm.getContacts();
//         
//        if(null != contacts && contacts.size() > 0) {
//            ContactController.contacts = contacts;
//            for (Contact contact : contacts) {
//                System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
//            }
//        }
//         
//        return new ModelAndView("show_contact", "contactForm", contactForm);
    }

	// TODO criar pagina de redirecionamento
	// http://www.javacodegeeks.com/2013/04/spring-mvc-form-handling-vol-1.html

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
			// refatorar para retornar uma imagem padrão
			return null;
	}

}