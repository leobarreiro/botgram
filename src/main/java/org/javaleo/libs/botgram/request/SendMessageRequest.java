package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import org.javaleo.libs.botgram.enums.ParseMode;
import org.javaleo.libs.botgram.model.BasicKeyboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

}
