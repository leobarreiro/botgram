package org.javaleo.libs.botgram.request;

import java.io.Serializable;

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

}
