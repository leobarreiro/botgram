package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("id")
	private Long id;

	@SerializedName("is_bot")
	private Boolean bot;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("username")
	private String username;

	@SerializedName("can_join_groups")
	private Boolean canJoinGroups;

	@SerializedName("can_read_all_group_messages")
	private Boolean canReadAllGroupMessages;

	@SerializedName("supports_inline_queries")
	private Boolean supportsInlineQueries;

	@SerializedName("language_code")
	private String languageCode;

}
