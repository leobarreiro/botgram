package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.TelegramFile;

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
public class GetFileResponse extends BotGramResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private TelegramFile file;

}
