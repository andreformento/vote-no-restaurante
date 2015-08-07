package br.com.formento.voteNoRestaurante.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "br.com.formento.voteNoRestaurante.service" })
public class SpringRootConfig {

}