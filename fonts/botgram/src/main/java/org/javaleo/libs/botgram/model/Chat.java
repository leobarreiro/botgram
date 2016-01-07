package org.javaleo.libs.botgram.model;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(schema = IBotGramPojo.SCHEMA, name = "chat")
public class Chat implements IBotGramPojo {

	private Integer id;
	private String type;
	
}
