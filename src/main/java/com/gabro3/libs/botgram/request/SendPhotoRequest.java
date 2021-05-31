package com.gabro3.libs.botgram.request;

import java.io.Serializable;

import com.gabro3.libs.botgram.model.BasicKeyboard;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendPhotoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("chat_id")
	private Integer chatId;

	@Expose
	@SerializedName("photo")
	private String fileName;

	@Expose
	@SerializedName("caption")
	private String caption;

	@Expose
	@SerializedName("disable_notification")
	private Boolean disableNotification;

	@Expose
	@SerializedName("reply_to_message_id")
	private Integer replyToMessageId;

	@Expose
	@SerializedName("reply_markup")
	private BasicKeyboard keyboard;

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Boolean getDisableNotification() {
		return disableNotification;
	}

	public void setDisableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
	}

	public Integer getReplyToMessageId() {
		return replyToMessageId;
	}

	public void setReplyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
	}

	public BasicKeyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(BasicKeyboard keyboard) {
		this.keyboard = keyboard;
	}

}
