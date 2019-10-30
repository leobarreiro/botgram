package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

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
public class Poll implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("question")
	private String question;

	@Expose
	@SerializedName("options")
	private List<PollOption> options;

	@Expose
	@SerializedName("is_closed")
	private boolean closed;

}
