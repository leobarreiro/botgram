package org.javaleo.libs.botgram.service;

import java.io.Serializable;

public interface IBotGramConfig extends Serializable {

	String urlMe();

	String urlUpdates(int offset, int limit);

	String urlSendMessage();

	String urlSendDocument();

	String urlFile(String fileId);
	
	String urlDownloadFile(String fileId);

}
