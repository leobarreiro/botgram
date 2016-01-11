package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("update_id")
	private Integer id;
	
	@SerializedName("message")
	private Message message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
