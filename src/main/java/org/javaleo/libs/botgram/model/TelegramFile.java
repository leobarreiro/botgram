package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TelegramFile implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("file_id")
	private String id;

	@SerializedName("file_size")
	private Long size;

	@SerializedName("file_path")
	private String path;

}
