package org.javaleo.libs.botgram.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javaleo.libs.botgram.annotations.BotGramPersistence;

public class BotGramPersistenceProducer {

	@Produces
	@PersistenceContext(unitName = "botgramPersistenceUnit")
	@BotGramPersistence
	private EntityManager entityManager;

}
