package com.gabro3.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

public class UserProfilePhotos implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer totalPhotos;
	private List<PhotoSize> photos;

	public Integer getTotalPhotos() {
		return totalPhotos;
	}

	public void setTotalPhotos(Integer totalPhotos) {
		this.totalPhotos = totalPhotos;
	}

	public List<PhotoSize> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoSize> photos) {
		this.photos = photos;
	}

}
