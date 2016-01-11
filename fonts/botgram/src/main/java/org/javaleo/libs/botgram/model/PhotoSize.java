package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class PhotoSize implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("file_id")
	private Integer id;

	@SerializedName("width")
	private Integer width;

	@SerializedName("height")
	private Integer height;

	@SerializedName("file_size")
	private Integer size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
