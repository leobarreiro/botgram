package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("update_id")
	private Long id;

	private Message message;

}
