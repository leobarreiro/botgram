package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class MessageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("type")
	private String type;

	@Expose
	@SerializedName("offset")
	private Integer offset;

	@Expose
	@SerializedName("length")
	private Integer length;

	@Expose
	@SerializedName("url")
	private String url;

	@Expose
	@SerializedName("user")
	private User user;

}
