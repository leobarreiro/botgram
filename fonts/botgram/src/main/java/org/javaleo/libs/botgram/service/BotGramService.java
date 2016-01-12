package org.javaleo.libs.botgram.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.javaleo.libs.botgram.model.File;
import org.javaleo.libs.botgram.model.Message;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class BotGramService implements IBotGramService {

	private static final long serialVersionUID = 1L;

	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String JSON_APPLICATION = "application/json; charset=UTF-8";

	@Inject
	private IBotGramConfig botGramConfig;

	private static final Logger LOG = LoggerFactory
			.getLogger(BotGramService.class);

	public User getMe() {
		String content = executeGetRequest(botGramConfig.getMeUrl());
		return null;
	}

	public List<Update> getUpdates(Integer offset, Integer limit) {
		return null;
	}

	public Message sendMessage(Message message) {
		return null;
	}

	public File getFile(String fileId) {
		return null;
	}

	private String executeGetRequest(String url) {
		StringBuffer content = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			content = new StringBuffer("");
			HttpGet httpGet = new HttpGet(url);
			prepareAuthorization(httpGet);
			HttpResponse response = httpClient.execute(httpGet);
			BufferedReader buffreader = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			String input = "";
			while ((input = buffreader.readLine()) != null) {
				content.append(input);
			}
			httpClient.close();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return content.toString();
	}

	private void prepareAuthorization(HttpMessage httpMessage) {
		httpMessage.addHeader(ACCEPT, JSON_APPLICATION);
	}

}
