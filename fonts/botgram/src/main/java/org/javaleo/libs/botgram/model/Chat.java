package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import org.javaleo.libs.botgram.enums.ChatType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("id")
	private Integer id;
	private ChatType type;

	@Expose
	@SerializedName("title")
	private String title;

	@Expose
	@SerializedName("username")
	private String username;

	@Expose
	@SerializedName("first_name")
	private String firstName;

	@Expose
	@SerializedName("last_name")
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ChatType getType() {
		return type;
	}

	public void setType(ChatType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
