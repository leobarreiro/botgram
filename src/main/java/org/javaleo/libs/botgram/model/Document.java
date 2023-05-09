package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("file_id")
	private String id;

	@SerializedName("file_name")
	private String name;

	@SerializedName("mime_type")
	private String mimeType;

	@SerializedName("file_size")
	private Long size;

}
