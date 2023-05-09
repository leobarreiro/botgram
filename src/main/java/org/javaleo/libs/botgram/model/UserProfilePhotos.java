package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UserProfilePhotos implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer totalPhotos;
	private List<PhotoSize> photos;

}
