package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Audio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("file_id")
	private String id;

	@Expose
	@SerializedName("duration")
	private Integer duration;

	@Expose
	@SerializedName("performer")
	private String performer;

	@Expose
	@SerializedName("performer")
	private String title;

	@Expose
	@SerializedName("mime_type")
	private String mimetype;

	@Expose
	@SerializedName("file_size")
	private Integer fileSize;

	@Expose
	@SerializedName("thumb")
	private PhotoSize thumb;

}
