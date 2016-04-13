package org.javaleo.libs.botgram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReplyKeyboardHide extends BasicKeyboard {

	private static final long serialVersionUID = 3L;

	@Expose
	@SerializedName("hide_keyboard")
	private boolean hideKeyboard;
	
	@Expose
	@SerializedName("selective")
	private boolean selective;

	public boolean isHideKeyboard() {
		return hideKeyboard;
	}

	public void setHideKeyboard(boolean hideKeyboard) {
		this.hideKeyboard = hideKeyboard;
	}

	public boolean isSelective() {
		return selective;
	}

	public void setSelective(boolean selective) {
		this.selective = selective;
	}

}
