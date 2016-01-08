package org.javaleo.libs.botgram.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.javaleo.libs.botgram.annotations.BotGramPersistence;
import org.javaleo.libs.botgram.entities.BotGramConfig;

@Stateless
public class BotGramConfigService implements IBotGramConfigService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@BotGramPersistence
	private EntityManager entityManager;

	public void saveConfig(BotGramConfig config) {
		if (config.getId() != null) {
			entityManager.merge(config);
		} else {
			entityManager.persist(config);
		}
	}

	@SuppressWarnings("unchecked")
	public List<BotGramConfig> listConfig() {
		Session session = (Session) entityManager.getDelegate();
		Criteria cr = session.createCriteria(BotGramConfig.class);
		return cr.list();
	}

}
