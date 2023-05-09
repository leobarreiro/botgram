package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("user_id")
	private Long userId;

}
