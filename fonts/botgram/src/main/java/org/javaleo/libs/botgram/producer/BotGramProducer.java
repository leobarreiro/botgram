package org.javaleo.libs.botgram.producer;

import javax.enterprise.inject.Produces;

import org.javaleo.libs.botgram.annotations.BotGrammer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class BotGramProducer {

	private static final String BOTGRAM_PROPERTIES = "/props/botgram.properties";
	private static final Logger LOG = LoggerFactory.getLogger(BotGramProducer.class);
	
	@Produces
	@BotGrammer
	public Properties loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(BotGramProducer.class.getResourceAsStream(BOTGRAM_PROPERTIES));
			return properties;
		} catch (IOException e) {
			LOG.error(e.getMessage());
			return null;
		}
	}
	
}
