package org.javaleo.libs.botgram.enums;

public enum ConfigKey {

	TELEGRAM_BOT("Telegram Bot URL"), TOKEN("API Token");

	private ConfigKey(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

}
