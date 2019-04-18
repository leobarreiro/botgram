package org.javaleo.libs.botgram.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ConfigKey {

	TELEGRAM_BOT("Telegram Bot URL"), TOKEN("API Token");

	@Getter
	@Setter
	private String description;

}
