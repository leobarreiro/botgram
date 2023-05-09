package org.javaleo.libs.botgram.response;

import java.io.Serializable;
import java.util.List;

import org.javaleo.libs.botgram.model.Update;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GetUpdatesResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean ok;

	@SerializedName("result")
	private List<Update> updates;

}
