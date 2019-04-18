package org.javaleo.libs.botgram.model;

import java.util.List;

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
public class ReplyKeyboardMarkup extends BasicKeyboard {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("keyboard")
	private List<List<String>> keyboard;

	@Expose
	@SerializedName("resize_keyboard")
	private boolean resizeKeyboard;
	
	@Expose
	@SerializedName("one_time_keyboard")
	private boolean oneTimeKeyboard;

	@Expose
	@SerializedName("selective")
	private boolean selective;

}
