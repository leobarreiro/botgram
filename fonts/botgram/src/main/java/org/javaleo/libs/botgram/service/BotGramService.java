package org.javaleo.libs.botgram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.BotGramHttpResponse;
import org.javaleo.libs.botgram.model.Document;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BotGramService implements IBotGramService {

	private static final long serialVersionUID = 1L;

	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String JSON_APPLICATION = "application/json; charset=UTF-8";
	public static final boolean DEBUG = true;

	private IBotGramConfig botGramConfig;

	public BotGramService() {
		super();
	}

	public BotGramService(IBotGramConfig botGramConfig) {
		super();
		this.botGramConfig = botGramConfig;
	}

	@Override
	public void setConfiguration(BotGramConfig config) {
		this.botGramConfig = config;
	}

	@Override
	public GetMeResponse getMe() throws BotGramException {
		try {
			BotGramHttpResponse response = executeGetRequest(botGramConfig.getMeUrl());
			Gson gson = createGson();
			GetMeResponse pojo = gson.fromJson(response.getContent(), GetMeResponse.class);
			pojo.setHttpResponseCode(response.getCode());
			pojo.setProtocol(response.getProtocol());
			return pojo;
		} catch (IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	@Override
	public GetUpdatesResponse getUpdates(Integer offset, Integer limit) throws BotGramException {
		try {
			BotGramHttpResponse response = executeGetRequest(botGramConfig.getUpdatesUrl());
			Gson gson = createGson();
			GetUpdatesResponse pojo = gson.fromJson(response.getContent(), GetUpdatesResponse.class);
			pojo.setHttpResponseCode(response.getCode());
			pojo.setProtocol(response.getProtocol());
			return pojo;
		} catch (IOException e) {
			throw new BotGramException(e.getMessage());
		}
	}

	@Override
	public SendMessageResponse sendMessage(SendMessageRequest request) throws BotGramException {
		try {
			Gson gson = createGson();
			StringEntity stringEntity = new StringEntity(gson.toJson(request).toString());
			BotGramHttpResponse response = executePostRequest(botGramConfig.getSendMessageUrl(), stringEntity);
			SendMessageResponse pojo = gson.fromJson(response.getContent(), SendMessageResponse.class);
			pojo.setHttpResponseCode(response.getCode());
			pojo.setProtocol(response.getProtocol());
			return pojo;
		} catch (IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	@Override
	public SendDocumentResponse sendDocument(SendDocumentRequest request) throws BotGramException {
		Gson gson = createGson();
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(botGramConfig.getSendDocumentUrl());
			Path path = Paths.get(request.getFileName());
			byte[] bytes = Files.readAllBytes(path);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addBinaryBody("document", bytes, ContentType.create(Files.probeContentType(path)), path.getFileName().toString());
			builder.addTextBody("chat_id", request.getChatId().toString(), ContentType.TEXT_PLAIN);
			HttpEntity entity = builder.build();
			post.setEntity(entity);
			HttpResponse response = httpClient.execute(post);
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer content = new StringBuffer();
			String input = "";
			while ((input = buffReader.readLine()) != null) {
				content.append(input);
			}
			SendDocumentResponse pojo = gson.fromJson(content.toString(), SendDocumentResponse.class);
			pojo.setHttpResponseCode(response.getStatusLine().getStatusCode());
			pojo.setProtocol(response.getProtocolVersion().getProtocol());
			if (DEBUG) {
				System.out.println("-  -  -  -  -  -  -  -  -  -  -");
				System.out.println(botGramConfig.getSendDocumentUrl());
				System.out.println(content.toString());
				System.out.println(response.getStatusLine().toString());
				System.out.println(response.getProtocolVersion().getProtocol());
				System.out.println(response.getStatusLine().getStatusCode());
			}
			httpClient.close();
			return pojo;
		} catch (IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	@Override
	public Document getFile(String fileId) throws BotGramException {
		return null;
	}

	private Gson createGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		return gsonBuilder.create();
	}

	private BotGramHttpResponse executeGetRequest(String url) throws IOException {
		BotGramHttpResponse botGramResponse = new BotGramHttpResponse();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		prepareAuthorization(httpGet);
		HttpResponse response = httpClient.execute(httpGet);
		botGramResponse.setProtocol(response.getStatusLine().getProtocolVersion().getProtocol());
		botGramResponse.setCode(response.getStatusLine().getStatusCode());
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer content = new StringBuffer();
		String input = "";
		while ((input = buffReader.readLine()) != null) {
			content.append(input);
		}
		botGramResponse.setContent(content.toString());
		if (DEBUG) {
			System.out.println("-  -  -  -  -  -  -  -  -  -  -");
			System.out.println(url);
			System.out.println(botGramResponse.getContent());
			System.out.println(response.getStatusLine().toString());
			System.out.println(botGramResponse.getProtocol());
			System.out.println(botGramResponse.getCode());
		}
		httpClient.close();
		return botGramResponse;
	}

	private BotGramHttpResponse executePostRequest(String url, HttpEntity entity) throws IOException {
		BotGramHttpResponse botGramResponse = new BotGramHttpResponse();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		prepareAuthorization(httpPost);
		httpPost.setEntity(entity);
		HttpResponse response = httpClient.execute(httpPost);
		botGramResponse.setProtocol(response.getStatusLine().getProtocolVersion().getProtocol());
		botGramResponse.setCode(response.getStatusLine().getStatusCode());
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer content = new StringBuffer();
		String input = "";
		while ((input = buffReader.readLine()) != null) {
			content.append(input);
		}
		botGramResponse.setContent(content.toString());
		if (DEBUG) {
			System.out.println("-  -  -  -  -  -  -  -  -  -  -");
			System.out.println(url);
			System.out.println(botGramResponse.getContent());
			System.out.println(response.getStatusLine().toString());
			System.out.println(botGramResponse.getProtocol());
			System.out.println(botGramResponse.getCode());
		}
		httpClient.close();
		return botGramResponse;
	}

	private void prepareAuthorization(HttpMessage httpMessage) {
		httpMessage.addHeader(ACCEPT, JSON_APPLICATION);
		httpMessage.addHeader(CONTENT_TYPE, JSON_APPLICATION);
	}

}
