package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import org.javaleo.libs.botgram.enums.ParseMode;
import org.javaleo.libs.botgram.model.ReplyKeyboardMarkup;

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
	private ReplyKeyboardMarkup replyKeyboardMarkup;

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

	public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
		return replyKeyboardMarkup;
	}

	public void setReplyKeyboardMarkup(ReplyKeyboardMarkup replyKeyboardMarkup) {
		this.replyKeyboardMarkup = replyKeyboardMarkup;
	}

}
