package org.javaleo.libs.botgram.util;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public class HttpRequestTelegramInterceptor implements HttpRequestInterceptor {

	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String JSON_APPLICATION = "application/json; charset=UTF-8";

	public HttpRequestTelegramInterceptor() {
		super();
	}

	@Override
	public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
		request.addHeader(ACCEPT, JSON_APPLICATION);
		request.addHeader(CONTENT_TYPE, JSON_APPLICATION);
	}

}
