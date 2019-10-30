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
public class PollOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("text")
	private String text;

	@Expose
	@SerializedName("voter_count")
	private Integer count;

}
