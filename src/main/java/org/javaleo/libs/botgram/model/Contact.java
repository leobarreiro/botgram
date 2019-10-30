package org.javaleo.libs.botgram.model;

import java.io.Serializable;

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
@EqualsAndHashCode
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

	@Expose
	@SerializedName("vcard")
	private String vcard;

}
