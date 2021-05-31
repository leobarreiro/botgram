package com.gabro3.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
	@SerializedName("text")
	private String text;

	@Expose
	@SerializedName("document")
	private Document document;

	@Expose
	@SerializedName("photo")
	private List<PhotoSize> photosizes;

	@Expose
	@SerializedName("contact")
	private Contact contact;

	@Expose
	@SerializedName("location")
	private Location location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getForward() {
		return forward;
	}

	public void setForward(User forward) {
		this.forward = forward;
	}

	public Integer getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(Integer forwardDate) {
		this.forwardDate = forwardDate;
	}

	public Message getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(Message replyMessage) {
		this.replyMessage = replyMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<PhotoSize> getPhotosizes() {
		return photosizes;
	}

	public void setPhotosizes(List<PhotoSize> photosizes) {
		this.photosizes = photosizes;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
