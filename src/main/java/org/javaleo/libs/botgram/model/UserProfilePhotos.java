package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserProfilePhotos implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer totalPhotos;
	private List<PhotoSize> photos;

}
