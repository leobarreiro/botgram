package org.javaleo.libs.botgram.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ReplyKeyboardMarkup implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<List<String>> keyboard;

	@SerializedName("resize_keyboard")
	private boolean resizeKeyboard;

	@SerializedName("one_time_keyboard")
	private boolean oneTimeKeyboard;

	private boolean selective;

}
