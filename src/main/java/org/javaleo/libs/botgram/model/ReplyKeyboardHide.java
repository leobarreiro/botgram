package org.javaleo.libs.botgram.model;

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
public class ReplyKeyboardHide extends BasicKeyboard {

	private static final long serialVersionUID = 3L;

	@Expose
	@SerializedName("hide_keyboard")
	private boolean hideKeyboard;
	
	@Expose
	@SerializedName("selective")
	private boolean selective;

}
