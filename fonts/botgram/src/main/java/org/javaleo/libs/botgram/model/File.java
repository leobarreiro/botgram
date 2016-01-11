package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class File implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("file_id")
	private String id;
	
	@SerializedName("file_size")
	private Integer size;
	
	@SerializedName("file_path")
	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
