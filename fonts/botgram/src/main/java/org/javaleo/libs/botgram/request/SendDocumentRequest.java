package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class SendDocumentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("chat_id")
	private Integer chatId;

	@SerializedName("document")
	private byte[] inputFile;

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public byte[] getInputFile() {
		return inputFile;
	}

	public void setInputFile(byte[] inputFile) {
		this.inputFile = inputFile;
	}

}
