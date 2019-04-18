package org.javaleo.libs.botgram.response;

import org.javaleo.libs.botgram.model.User;

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
public class GetMeResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private User user;

}
