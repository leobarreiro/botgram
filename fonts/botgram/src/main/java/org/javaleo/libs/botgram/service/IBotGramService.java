package org.javaleo.libs.botgram.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import org.javaleo.libs.botgram.model.File;
import org.javaleo.libs.botgram.model.Message;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.model.User;

@Local
public interface IBotGramService extends Serializable {

	User getMe();

	List<Update> getUpdates(Integer offset, Integer limit);

	Message sendMessage(Message message);
	
	File getFile(String fileId);

}
