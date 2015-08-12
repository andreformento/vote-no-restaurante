package br.com.formento.voteNoRestaurante.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkMailImpl implements LinkMail {
	private String urlBase;
	private String link;

	private Map<String, Object> parameters;

	public LinkMailImpl(String urlBase, String link) {
		this.urlBase = urlBase;
		this.link = link;
		this.parameters = new LinkedHashMap<>();
	}

	public String getUrlBase() {
		return urlBase;
	}

	public String getLink() {
		return link;
	}

	@Override
	public void addParameter(String name, Object value) {
		parameters.put(name, value);
	}

	@Override
	public String generateFullLink() {
		StringBuilder fullLink = new StringBuilder();

		fullLink.append(urlBase);
		fullLink.append(link);

		String concat = "?";
		for (Entry<String, Object> param : parameters.entrySet()) {
			if (param.getValue() != null) {
				fullLink.append(concat);
				fullLink.append(param.getKey());
				fullLink.append("=");
				fullLink.append(param.getValue());

				concat = "&";
			}
		}

		return fullLink.toString();
	}

}
