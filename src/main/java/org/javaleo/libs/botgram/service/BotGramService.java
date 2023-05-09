package org.javaleo.libs.botgram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetFileResponse;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;
import org.javaleo.libs.botgram.util.CustomHttpClient;
import org.javaleo.libs.botgram.util.JsonUtil;

import com.google.gson.JsonSyntaxException;

public class BotGramService implements IBotGramService {

	private static final long serialVersionUID = 1L;

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
		var jsonUtil = new JsonUtil<GetMeResponse>(GetMeResponse.class);
		return jsonUtil.execGet(botGramConfig.getMeUrl());
	}

	@Override
	public GetUpdatesResponse getUpdates(Integer offset, Integer limit) throws BotGramException {
		offset = (offset == null) ? 0 : offset;
		limit = (limit == null) ? 0 : limit;
		var url = botGramConfig.getUpdatesUrl(offset, limit);
		var jsonUtil = new JsonUtil<GetUpdatesResponse>(GetUpdatesResponse.class);
		return jsonUtil.execGet(url);
	}

	@Override
	public SendMessageResponse sendMessage(SendMessageRequest request) throws BotGramException {
		var jsonUtil = new JsonUtil<SendMessageResponse>(SendMessageResponse.class);
		return jsonUtil.execPost(botGramConfig.getSendMessageUrl(), jsonUtil.getStringEntity(request));
	}

	@Override
	public SendDocumentResponse sendDocument(SendDocumentRequest request) throws BotGramException {
		var gson = CustomHttpClient.createGson();
		try {
			var httpClient = CustomHttpClient.getHttpClientFiles();
			var post = new HttpPost(botGramConfig.getSendDocumentUrl());
			var path = Paths.get(request.getFileName());
			byte[] bytes = Files.readAllBytes(path);
			var builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addBinaryBody("document", bytes, ContentType.create(Files.probeContentType(path)), path.getFileName().toString());
			builder.addTextBody("chat_id", request.getChatId().toString(), ContentType.TEXT_PLAIN);
			var entity = builder.build();
			post.setEntity(entity);
			var response = httpClient.execute(post);
			var buffReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			var content = new StringBuilder();
			var input = "";
			while ((input = buffReader.readLine()) != null) {
				content.append(input);
			}
			var pojo = gson.fromJson(content.toString(), SendDocumentResponse.class);
			httpClient.close();
			return pojo;
		} catch (JsonSyntaxException | IOException e) {
			throw new BotGramException(e.getMessage(), e);
		}
	}

	@Override
	public GetFileResponse getFile(String fileId) throws BotGramException {
		var jsonUtil = new JsonUtil<GetFileResponse>(GetFileResponse.class);
		return jsonUtil.execGet(botGramConfig.getFileUrl(fileId));
	}

	@Override
	public String getFileUrlDownload(String fileId) throws BotGramException {
		return botGramConfig.getUrlDownloadFile(fileId);
	}

}
