package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.BasicKeyboard;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SendDocumentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("chat_id")
	private Long chatId;

	@SerializedName("document")
	private String fileName;

	@SerializedName("caption")
	private String caption;

	@SerializedName("disable_notification")
	private Boolean disableNotification;

	@SerializedName("reply_to_message_id")
	private Long replyToMessageId;

	@SerializedName("reply_markup")
	private BasicKeyboard keyboard;

}
