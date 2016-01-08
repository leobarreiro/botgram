package org.javaleo.libs.botgram.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import org.javaleo.libs.botgram.entities.BotGramConfig;

@Local
public interface IBotGramConfigService extends Serializable {

	void saveConfig(BotGramConfig config);

	List<BotGramConfig> listConfig();

}
