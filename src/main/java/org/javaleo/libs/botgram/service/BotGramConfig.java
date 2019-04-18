package org.javaleo.libs.botgram.service;

import java.text.MessageFormat;
import java.util.Properties;

import org.javaleo.libs.botgram.producer.BotGramProducer;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class BotGramConfig implements IBotGramConfig {

	private static final long serialVersionUID = 1L;

	private static final String GETME = "getMe";
	private static final String GETUPDATES = "getUpdates";
	private static final String SENDMESSAGE = "sendMessage";
	private static final String SENDDOCUMENT = "sendDocument";
	//private static final String GETFILE = "getFile";

	private Properties properties;

	private String token;

	@Override
	public String urlMe() {
		StringBuilder str = urlApi();
		str.append(GETME);
		return str.toString();
	}

	public String urlUpdates(int offset, int limit) {
		StringBuilder str = urlApi();
		str.append(GETUPDATES);
		str.append("?offset=");
		str.append(offset);
		str.append("&limit=");
		str.append(limit);
		return str.toString();
	}

	@Override
	public String urlSendMessage() {
		StringBuilder str = urlApi();
		str.append(SENDMESSAGE);
		return str.toString();
	}

	@Override
	public String urlSendDocument() {
		StringBuilder str = urlApi();
		str.append(SENDDOCUMENT);
		return str.toString();
	}
	
	@Override
	public String urlFile(String fileId) {
		properties = BotGramProducer.loadProperties();
		StringBuilder str = urlApi();
		str.append("getFile");
		str.append("?file_id=");
		str.append(fileId);
		return str.toString();
	}
	
	@Override
	public String urlDownloadFile(String fileId) {
		properties = BotGramProducer.loadProperties();
		String url = properties.getProperty("telegram.file.url");
		return MessageFormat.format(url, this.token, fileId);
	}

	private StringBuilder urlApi() {
		properties = BotGramProducer.loadProperties();
		String url = properties.getProperty("telegram.url");
		StringBuilder str = new StringBuilder(MessageFormat.format(url, this.token));
		return str;
	}

}
