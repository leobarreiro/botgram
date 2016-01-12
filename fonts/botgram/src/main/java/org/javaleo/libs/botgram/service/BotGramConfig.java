package org.javaleo.libs.botgram.service;

import java.util.Properties;

import javax.ejb.Singleton;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.javaleo.libs.botgram.annotations.BotGrammer;

@Singleton
public class BotGramConfig implements IBotGramConfig {

	private static final long serialVersionUID = 1L;

	private static final String GETME = "getMe";
	private static final String GETUPDATES = "getUpdates";
	private static final String SLASH = "/";

	@Inject
	@BotGrammer
	private Properties properties;

	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	public String getMeUrl() {
		StringBuilder str = getApiUrl();
		str.append(GETME);
		return str.toString();
	}

	public String getUpdatesUrl() {
		StringBuilder str = getApiUrl();
		str.append(GETUPDATES);
		return str.toString();
	}

	private StringBuilder getApiUrl() {
		String url = properties.getProperty("telegram.url");
		StringBuilder str = new StringBuilder(StringUtils.replace(url,
				"<token>", this.token));
		return str;
	}

}
