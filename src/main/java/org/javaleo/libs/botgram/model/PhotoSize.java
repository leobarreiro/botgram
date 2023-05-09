package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PhotoSize implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("file_id")
	private String id;

	private Integer width;

	private Integer height;

	@SerializedName("file_size")
	private Long size;

}
