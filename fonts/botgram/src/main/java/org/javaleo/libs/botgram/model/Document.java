package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("file_id")
	private String id;

	@Expose
	@SerializedName("file_name")
	private String name;

	@Expose
	@SerializedName("mime_type")
	private String mimeType;

	@Expose
	@SerializedName("file_size")
	private Integer size;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
