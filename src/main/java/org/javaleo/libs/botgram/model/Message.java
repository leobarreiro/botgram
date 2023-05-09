package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("message_id")
	private Long id;

	private User from;

	private Long date;

	private Chat chat;

	@SerializedName("forward_from")
	private User forward;

	@SerializedName("forward_date")
	private Long forwardDate;

	@SerializedName("reply_to_message")
	private Message replyMessage;

	private String text;

	private Document document;

	@SerializedName("photo")
	private List<PhotoSize> photosizes;

	private Contact contact;

	private Location location;

}
