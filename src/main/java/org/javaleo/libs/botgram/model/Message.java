package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

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
@EqualsAndHashCode(
		of = { "id", "from", "date", "chat", "text" })
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("message_id")
	private Integer id;

	@Expose
	@SerializedName("from")
	private User from;

	@Expose
	@SerializedName("date")
	private Integer date;

	@Expose
	@SerializedName("chat")
	private Chat chat;

	@Expose
	@SerializedName("forward_from")
	private User forward;

	@Expose
	@SerializedName("forward_date")
	private Integer forwardDate;

	@Expose
	@SerializedName("reply_to_message")
	private Message replyMessage;

	@Expose
	@SerializedName("author_signature")
	private String authorSignature;

	@Expose
	@SerializedName("text")
	private String text;

	@Expose
	@SerializedName("entities")
	private List<MessageEntity> entities;

	@Expose
	@SerializedName("caption_entities")
	private List<MessageEntity> captionEntities;

	@Expose
	@SerializedName("audio")
	private Audio audio;

	@Expose
	@SerializedName("document")
	private Document document;

	@Expose
	@SerializedName("animation")
	private Animation animation;

	@Expose
	@SerializedName("photo")
	private List<PhotoSize> photosizes;

	@Expose
	@SerializedName("contact")
	private Contact contact;

	@Expose
	@SerializedName("location")
	private Location location;

	@Expose
	@SerializedName("poll")
	private Poll poll;

}
