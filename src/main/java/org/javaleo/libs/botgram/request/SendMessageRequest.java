package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import org.javaleo.libs.botgram.enums.ParseMode;
import org.javaleo.libs.botgram.model.BasicKeyboard;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SendMessageRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("chat_id")
	private Long chatId;

	@SerializedName("text")
	private String text;

	@SerializedName("parse_mode")
	private ParseMode parseMode;

	@SerializedName("disable_web_page_preview")
	private Boolean disableWebPagePreview;

	@SerializedName("reply_markup")
	private BasicKeyboard keyboard;

}
