package org.javaleo.libs.botgram.producer;

import java.io.IOException;
import java.util.Properties;

public class BotGramProducer {

	private static final String BOTGRAM_PROPERTIES = "/props/botgram.properties";

	private BotGramProducer() {
		super();
	}

	public static Properties loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(BotGramProducer.class.getResourceAsStream(BOTGRAM_PROPERTIES));
			return properties;
		} catch (IOException e) {
			return properties;
		}
	}

}
