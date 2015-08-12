package br.com.formento.voteNoRestaurante.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class AplicacaoParametro implements Serializable {

	private static final long serialVersionUID = 1L;

	private static AplicacaoParametro instance;

	public static AplicacaoParametro getInstance() {
		if (instance == null)
			instance = new AplicacaoParametro();
		return instance;
	}

	private final String emailUsername;
	private final String emailPassword;

	private AplicacaoParametro() {
		String emailUsernameInterno = "email@gmail.com";
		String emailPasswordInterno = "";

		String diretorioHome = System.getProperty("user.home");

		File arquivoPropriedade = new File(diretorioHome + "/vote-no-restaurante.properties");
		if (arquivoPropriedade.isFile()) {
			FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(arquivoPropriedade);

				Properties properties = new Properties();
				properties.load(fileInputStream);

				emailUsernameInterno = properties.getProperty("email.username", emailUsernameInterno);
				emailPasswordInterno = properties.getProperty("email.password", emailPasswordInterno);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		emailUsername = emailUsernameInterno;
		emailPassword = emailPasswordInterno;
	}

	public String getEmailUsername() {
		return emailUsername;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

}
