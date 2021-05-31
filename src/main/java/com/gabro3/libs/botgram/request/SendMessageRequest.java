package com.gabro3.libs.botgram.request;

import java.io.Serializable;

import com.gabro3.libs.botgram.enums.ParseMode;
import com.gabro3.libs.botgram.model.BasicKeyboard;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendMessageRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("chat_id")
	private Integer chatId;

	@Expose
	@SerializedName("text")
	private String text;

	@Expose
	@SerializedName("parse_mode")
	private ParseMode parseMode;

	@Expose
	@SerializedName("disable_web_page_preview")
	private Boolean disableWebPagePreview;

	@Expose
	@SerializedName("reply_markup")
	private BasicKeyboard keyboard;

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

	public BasicKeyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(BasicKeyboard keyboard) {
		this.keyboard = keyboard;
	}

}
