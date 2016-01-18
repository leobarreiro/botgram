package org.javaleo.libs.botgram.service;

import java.io.Serializable;
import java.util.List;

import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.File;
import org.javaleo.libs.botgram.model.Message;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;

public interface IBotGramService extends Serializable {

	void setConfiguration(BotGramConfig config);
	
	GetMeResponse getMe() throws BotGramException;

	GetUpdatesResponse getUpdates(Integer offset, Integer limit) throws BotGramException;

	SendMessageResponse sendMessage(SendMessageRequest request) throws BotGramException;
	
	File getFile(String fileId) throws BotGramException;

}
