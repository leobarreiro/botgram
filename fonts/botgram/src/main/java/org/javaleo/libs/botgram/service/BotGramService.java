package org.javaleo.libs.botgram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.File;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;

import com.google.gson.Gson;

public class BotGramService implements IBotGramService {

	private static final long serialVersionUID = 1L;

	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String JSON_APPLICATION = "application/json; charset=UTF-8";

	private IBotGramConfig botGramConfig;

	public BotGramService() {
		super();
	}

	public BotGramService(IBotGramConfig botGramConfig) {
		super();
		this.botGramConfig = botGramConfig;
	}

	public void setConfiguration(BotGramConfig config) {
		this.botGramConfig = config;
	}

	public GetMeResponse getMe() throws BotGramException {
		try {
			String content = executeGetRequest(botGramConfig.getMeUrl());
			Gson gson = new Gson();
			GetMeResponse response = gson.fromJson(content, GetMeResponse.class);
			return response;
		} catch (ClientProtocolException e) {
			throw new BotGramException(e.getMessage(), e);
		} catch (IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	public GetUpdatesResponse getUpdates(Integer offset, Integer limit) throws BotGramException {
		String content;
		try {
			content = executeGetRequest(botGramConfig.getUpdatesUrl());
			Gson gson = new Gson();
			GetUpdatesResponse response = gson.fromJson(content, GetUpdatesResponse.class);
			return response;
		} catch (ClientProtocolException e) {
			throw new BotGramException(e.getMessage());
		} catch (IOException e) {
			throw new BotGramException(e.getMessage());
		}
	}

	public SendMessageResponse sendMessage(SendMessageRequest request) throws BotGramException {
		try {
			Gson gson = new Gson();
			StringEntity stringEntity = new StringEntity(gson.toJson(request).toString());
			String content = executePostRequest(botGramConfig.getSendMessageUrl(), stringEntity);
			SendMessageResponse response = gson.fromJson(content, SendMessageResponse.class);
			return response;
		} catch (UnsupportedEncodingException e) {
			throw new BotGramException(e.getMessage(), e);
		} catch (ClientProtocolException e) {
			throw new BotGramException(e.getMessage(), e);
		} catch (IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	public File getFile(String fileId) throws BotGramException {
		return null;
	}

	private String executeGetRequest(String url) throws ClientProtocolException, IOException {
		StringBuffer content = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		content = new StringBuffer("");
		HttpGet httpGet = new HttpGet(url);
		prepareAuthorization(httpGet);
		HttpResponse response = httpClient.execute(httpGet);
		BufferedReader buffreader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String input = "";
		while ((input = buffreader.readLine()) != null) {
			content.append(input);
		}
		httpClient.close();
		return content.toString();
	}

	private String executePostRequest(String url, StringEntity stringEntity) throws ClientProtocolException, IOException {
		StringBuffer content = new StringBuffer("");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		prepareAuthorization(httpPost);
		httpPost.setEntity(stringEntity);
		HttpResponse response = httpClient.execute(httpPost);
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String input = "";
		while ((input = buffReader.readLine()) != null) {
			content.append(input);
		}
		httpClient.close();
		return content.toString();
	}

	private void prepareAuthorization(HttpMessage httpMessage) {
		httpMessage.addHeader(ACCEPT, JSON_APPLICATION);
		httpMessage.addHeader(CONTENT_TYPE, JSON_APPLICATION);
	}

	public SendDocumentResponse sendDocument(SendDocumentRequest request) throws BotGramException {
		// TODO Auto-generated method stub
		return null;
	}

}
