package org.javaleo.libs.botgram.service;

import java.io.Serializable;

public interface IBotGramConfig extends Serializable {

	void setToken(final String token);

	String getMeUrl();

	String getUpdatesUrl(int offset, int limit);

	String getSendMessageUrl();

	String getSendDocumentUrl();

}
