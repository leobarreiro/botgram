package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.Message;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SendMessageResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean ok;

	@SerializedName("result")
	private Message message;

}
