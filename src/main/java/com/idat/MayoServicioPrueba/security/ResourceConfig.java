package com.idat.MayoServicioPrueba.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

	//Implementar metodos por el IDE
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		super.configure(resources);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Las peticiones anonimas no estaran autorizados
		//Para que accedan al recurso deben estar autenticadas
		http.anonymous().disable();
		
		//Recursos al que estaran autorizados los usuarios
		http.authorizeRequests()
		.antMatchers("/producto/v1/**").permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(new OAuth2AccessDeniedHandler()); // Si causa error le mandamos un token
																// de acceso denegado
	}

}
