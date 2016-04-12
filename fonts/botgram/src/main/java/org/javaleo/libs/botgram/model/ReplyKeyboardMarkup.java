package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReplyKeyboardMarkup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("keyboard")
	private String keyboard;

	@Expose
	@SerializedName("resize_keyboard")
	private boolean resizeKeyboard;

	@Expose
	@SerializedName("one_time_keyboard")
	private boolean oneTimeKeyboard;

	@Expose
	@SerializedName("selective")
	private boolean selective;

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public boolean isResizeKeyboard() {
		return resizeKeyboard;
	}

	public void setResizeKeyboard(boolean resizeKeyboard) {
		this.resizeKeyboard = resizeKeyboard;
	}

	public boolean isOneTimeKeyboard() {
		return oneTimeKeyboard;
	}

	public void setOneTimeKeyboard(boolean oneTimeKeyboard) {
		this.oneTimeKeyboard = oneTimeKeyboard;
	}

	public boolean isSelective() {
		return selective;
	}

	public void setSelective(boolean selective) {
		this.selective = selective;
	}

}
