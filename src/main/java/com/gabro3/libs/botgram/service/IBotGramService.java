package com.gabro3.libs.botgram.service;

import java.io.Serializable;

import com.gabro3.libs.botgram.exceptions.BotGramException;
import com.gabro3.libs.botgram.request.SendDocumentRequest;
import com.gabro3.libs.botgram.request.SendMessageRequest;
import com.gabro3.libs.botgram.response.GetFileResponse;
import com.gabro3.libs.botgram.response.GetMeResponse;
import com.gabro3.libs.botgram.response.GetUpdatesResponse;
import com.gabro3.libs.botgram.response.SendDocumentResponse;
import com.gabro3.libs.botgram.response.SendMessageResponse;

public interface IBotGramService extends Serializable {

	void setConfiguration(BotGramConfig config);

	GetMeResponse getMe() throws BotGramException;

	GetUpdatesResponse getUpdates(Integer offset, Integer limit) throws BotGramException;

	SendMessageResponse sendMessage(SendMessageRequest request) throws BotGramException;

	GetFileResponse getFile(String fileId) throws BotGramException;
	
	String getFileUrlDownload(String fileId) throws BotGramException;

	SendDocumentResponse sendDocument(SendDocumentRequest request) throws BotGramException;

}
