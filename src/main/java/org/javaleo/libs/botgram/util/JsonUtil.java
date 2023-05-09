package org.javaleo.libs.botgram.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.javaleo.libs.botgram.exceptions.BotGramException;

public class JsonUtil<T extends Serializable> {

	private Class<T> paramClass;

	public JsonUtil(Class<T> typeParameterClass) {
		this.paramClass = typeParameterClass;
	}

	public T execGet(final String url) throws BotGramException {
		try {
			var response = CustomHttpClient.executeGetRequest(url);
			var gson = CustomHttpClient.createGson();
			return gson.fromJson(response.getContent(), paramClass);
		} catch (Exception e) {
			throw new BotGramException(e.getMessage());
		}
	}

	public T execPost(final String url, HttpEntity httpEntity) throws BotGramException {
		try {
			var response = CustomHttpClient.executePostRequest(url, httpEntity);
			var gson = CustomHttpClient.createGson();
			return gson.fromJson(response.getContent(), paramClass);
		} catch (Exception e) {
			throw new BotGramException(e.getMessage());
		}
	}
	
	public StringEntity getStringEntity(Object obj) throws BotGramException {
		try {
			var gson = CustomHttpClient.createGson();
			return new StringEntity(gson.toJson(obj));
		} catch (UnsupportedEncodingException e) {
			throw new BotGramException(e.getMessage());
		}
	}

}
