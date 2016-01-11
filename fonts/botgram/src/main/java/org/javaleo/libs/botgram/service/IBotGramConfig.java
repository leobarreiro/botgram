package org.javaleo.libs.botgram.service;

import java.io.Serializable;

import javax.ejb.Local;

@Local
public interface IBotGramConfig extends Serializable {

	void setToken(final String token);
	
	String getToken();
	
}
