package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String type;

	private String title;

	private String username;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	private List<Message> messages;

}
