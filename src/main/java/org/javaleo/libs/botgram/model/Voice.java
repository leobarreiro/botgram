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

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Voice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("file_id")
	private String id;

	@Expose
	@SerializedName("length")
	private Integer length;

	@Expose
	@SerializedName("duration")
	private Integer duration;

	@Expose
	@SerializedName("thumb")
	private PhotoSize thumb;

	@Expose
	@SerializedName("file_size")
	private String size;
}
