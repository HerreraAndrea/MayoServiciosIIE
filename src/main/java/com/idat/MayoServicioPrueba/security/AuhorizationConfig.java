package com.idat.MayoServicioPrueba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableAuthorizationServer
public class AuhorizationConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager manager;
	
	//Token de Acceso
	@Autowired
	private TokenStore store;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	//Configuraciones del Cliente: 
	/*
	 * Oauth
	 * username = client-id
	 * password = client-secret
	 * */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//Generar token
		clients.inMemory()
		.withClient("queridoprofesor")
		.secret(new BCryptPasswordEncoder().encode("queridoprofesor"))
		.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
		.scopes("read", "write", "trust")
		.accessTokenValiditySeconds(1*60*60)
		.refreshTokenValiditySeconds(5*60*60);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// Va a tomar el token creado para almacenar en el campo 'token'
		endpoints.tokenStore(store)
		.authenticationManager(manager);
	}

}
