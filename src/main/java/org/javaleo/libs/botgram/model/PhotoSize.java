package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

}
