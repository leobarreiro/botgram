package org.javaleo.libs.botgram.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.javaleo.libs.botgram.model.BotGramHttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;

@Getter
public class CustomHttpClient {

	private static final String USER_AGENT = "botgram-lib";
	private Integer maxTotalConnections;
	private Integer maxPerRouteConnections;

	public static PoolingHttpClientConnectionManager httpClientCustomPooling() {
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal((System.getenv("MAX_TOTAL_CONNECTIONS") != null) ? Integer.valueOf(System.getenv("MAX_TOTAL_CONNECTIONS")) : 20);
		connManager.setDefaultMaxPerRoute((System.getenv("MAX_PER_ROUTE_CONNECTIONS") != null) ? Integer.valueOf(System.getenv("MAX_PER_ROUTE_CONNECTIONS")) : 10);
		return connManager;
	}

	public static CloseableHttpClient getHttpClientJson() {
		return HttpClients.custom()
		.setUserAgent(USER_AGENT)
		.setConnectionManager(httpClientCustomPooling())
		.setConnectionManagerShared(true)
		.addInterceptorFirst(new HttpRequestTelegramInterceptor())
		.build();
	}

	public static CloseableHttpClient getHttpClientFiles() {
		return HttpClients.custom()
		.setUserAgent(USER_AGENT)
		.setConnectionManager(httpClientCustomPooling())
		.setConnectionManagerShared(true)
		.build();
	}

	public static BotGramHttpResponse executePostRequest(String url, HttpEntity entity) throws IOException {
		var botGramResponse = new BotGramHttpResponse();
		var httpClient = CustomHttpClient.getHttpClientJson();
		var httpPost = new HttpPost(url);
		httpPost.setEntity(entity);
		var response = httpClient.execute(httpPost);
		botGramResponse.setProtocol(response.getStatusLine().getProtocolVersion().getProtocol());
		botGramResponse.setCode(response.getStatusLine().getStatusCode());
		var buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		var content = new StringBuilder();
		var input = "";
		while ((input = buffReader.readLine()) != null) {
			content.append(input);
		}
		botGramResponse.setContent(content.toString());
		httpClient.close();
		return botGramResponse;
	}

	public static BotGramHttpResponse executeGetRequest(String url) throws IOException {
		var botGramResponse = new BotGramHttpResponse();
		var httpClient = CustomHttpClient.getHttpClientJson();
		var httpGet = new HttpGet(url);
		var response = httpClient.execute(httpGet);
		botGramResponse.setProtocol(response.getStatusLine().getProtocolVersion().getProtocol());
		botGramResponse.setCode(response.getStatusLine().getStatusCode());
		var buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		var content = new StringBuilder();
		var input = "";
		while ((input = buffReader.readLine()) != null) {
			content.append(input);
		}
		botGramResponse.setContent(content.toString());
		httpClient.close();
		return botGramResponse;
	}

	public static Gson createGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		return gsonBuilder.create();
	}

}
