package org.javaleo.libs.botgram.service;

import javax.ejb.Singleton;

@Singleton
public class BotGramConfig implements IBotGramConfig {

	private static final long serialVersionUID = 1L;
	
	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
