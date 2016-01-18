package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import org.javaleo.libs.botgram.enums.ParseMode;

import com.google.gson.annotations.SerializedName;

public class SendMessageRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("chat_id")
	private Integer chatId;

	@SerializedName("text")
	private String text;

	@SerializedName("parse_mode")
	private ParseMode parseMode;

	@SerializedName("disable_web_page_preview")
	private Boolean disableWebPagePreview;

	// TODO : explore reply_markup in this object. View Telegram API docs.

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ParseMode getParseMode() {
		return parseMode;
	}

	public void setParseMode(ParseMode parseMode) {
		this.parseMode = parseMode;
	}

	public Boolean getDisableWebPagePreview() {
		return disableWebPagePreview;
	}

	public void setDisableWebPagePreview(Boolean disableWebPagePreview) {
		this.disableWebPagePreview = disableWebPagePreview;
	}

}
