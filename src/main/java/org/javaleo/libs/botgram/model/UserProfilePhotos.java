package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

	@Expose
	@SerializedName("total_count")
	private Integer totalCount;

	@Expose
	@SerializedName("photos")
	private List<PhotoSize> photos;

}
