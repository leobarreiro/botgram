package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ReplyKeyboardHide implements Serializable {

	private static final long serialVersionUID = 3L;

	@SerializedName("hide_keyboard")
	private boolean hideKeyboard;

	private Boolean selective;

}
