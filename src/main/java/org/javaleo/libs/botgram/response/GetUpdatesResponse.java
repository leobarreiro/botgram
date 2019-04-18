package org.javaleo.libs.botgram.response;

import java.util.List;

import org.javaleo.libs.botgram.model.Update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUpdatesResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private List<Update> updates;

}
