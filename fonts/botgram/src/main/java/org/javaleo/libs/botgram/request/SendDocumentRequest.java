package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendDocumentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("chat_id")
	private Integer chatId;

	// @Expose(deserialize = false, serialize = false)
	// private byte[] inputFile;
	//
	// @Expose(deserialize = false, serialize = false)
	// private String contentType;
	//

	@Expose
	@SerializedName("document")
	private String fileName;

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	// public byte[] getInputFile() {
	// return inputFile;
	// }
	//
	// public void setInputFile(byte[] inputFile) {
	// this.inputFile = inputFile;
	// }
	//
	// public String getContentType() {
	// return contentType;
	// }
	//
	// public void setContentType(String contentType) {
	// this.contentType = contentType;
	// }
	//

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
