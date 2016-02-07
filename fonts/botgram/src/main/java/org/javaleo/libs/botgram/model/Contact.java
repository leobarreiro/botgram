package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("phone_number")
	private String phoneNumber;

	@Expose
	@SerializedName("first_name")
	private String firstName;

	@Expose
	@SerializedName("last_name")
	private String lastName;

	@Expose
	@SerializedName("user_id")
	private Integer userId;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
