package org.javaleo.libs.botgram.service;

import java.text.MessageFormat;
import java.util.Properties;

import org.javaleo.libs.botgram.producer.BotGramProducer;

public class BotGramConfig implements IBotGramConfig {

	private static final long serialVersionUID = 1L;

	private static final String GETME = "getMe";
	private static final String GETUPDATES = "getUpdates";
	private static final String SENDMESSAGE = "sendMessage";
	private static final String SENDDOCUMENT = "sendDocument";
	private static final String GETFILE = "getFile";

	private Properties properties;

	private String token;

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String getMeUrl() {
		var str = getApiUrl();
		str.append(GETME);
		return str.toString();
	}

	public String getUpdatesUrl(int offset, int limit) {
		var str = getApiUrl();
		str.append(GETUPDATES);
		str.append("?offset=");
		str.append(offset);
		str.append("&limit=");
		str.append(limit);
		return str.toString();
	}

	@Override
	public String getSendMessageUrl() {
		var str = getApiUrl();
		str.append(SENDMESSAGE);
		return str.toString();
	}

	@Override
	public String getSendDocumentUrl() {
		var str = getApiUrl();
		str.append(SENDDOCUMENT);
		return str.toString();
	}

	@Override
	public String getFileUrl(String fileId) {
		properties = BotGramProducer.loadProperties();
		var str = getApiUrl();
		str.append(GETFILE);
		str.append("?file_id=");
		str.append(fileId);
		return str.toString();
	}

	@Override
	public String getUrlDownloadFile(String fileId) {
		properties = BotGramProducer.loadProperties();
		var url = properties.getProperty("telegram.file.url");
		return MessageFormat.format(url, this.token, fileId);
	}

	private StringBuilder getApiUrl() {
		properties = BotGramProducer.loadProperties();
		var url = properties.getProperty("telegram.url");
		return new StringBuilder(MessageFormat.format(url, this.token));
	}

}
