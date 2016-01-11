package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("message_id")
	private Integer id;
	
	@SerializedName("from")
	private User from;
	
	@SerializedName("date")
	private Integer date;
	
	@SerializedName("chat")
	private Chat chat;
	
	@SerializedName("forward_from")
	private User forward;
	
	@SerializedName("forward_date")
	private Integer forwardDate;
	
	@SerializedName("reply_to_message")
	private Message replyMessage;
	
	@SerializedName("text")
	private String text;
	
	@SerializedName("contact")
	private Contact contact;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
