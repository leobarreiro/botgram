package com.gabro3.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoSize implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("file_id")
	private String id;

	@Expose
	@SerializedName("width")
	private Integer width;

	@Expose
	@SerializedName("height")
	private Integer height;

	@Expose
	@SerializedName("file_size")
	private Integer size;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
