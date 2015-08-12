package br.com.formento.voteNoRestaurante.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.formento.voteNoRestaurante.model.AplicacaoParametro;

// TODO refatorar: o nome e senha devem ser buscados atraves de algum arquivo de configuracao do servidor
@Configuration
@PropertySource({ "classpath:mail.properties" })
public class MailConfig {

	@Value("${host}")
	private String host;

	@Value("${port}")
	private Integer port;

	private String username;

	private String password;

	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost(host);
		javaMailSender.setPort(port);

		username = AplicacaoParametro.getInstance().getEmailUsername();
		password = AplicacaoParametro.getInstance().getEmailPassword();

		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "false");
		return properties;
	}
}