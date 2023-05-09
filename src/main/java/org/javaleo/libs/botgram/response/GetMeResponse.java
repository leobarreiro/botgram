package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.User;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GetMeResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean ok;

	@SerializedName("result")
	private User user;

}
