package org.javaleo.libs.botgram.service;

import static org.junit.Assert.assertTrue;

import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.junit.Test;

public class BotGramServiceTest {

	@Test
	public void getMeTest() {
		BotGramService service = buildService();
		GetMeResponse response;
		try {
			response = service.getMe();
			System.out.println(response.getUser().getId());
			System.out.println(response.getUser().getFirstName());
			assertTrue("GetMe Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
	}

	public void getUpdates() {
		BotGramService service = buildService();
		GetUpdatesResponse response;
		try {
			response = service.getUpdates(0, 10);
			assertTrue("GetUpdates Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
	}

	private BotGramService buildService() {
		BotGramConfig cfg = new BotGramConfig();
		// @MinhaSaudeBot
		cfg.setToken("143190108:AAHO8fKsnY85RsnoVN8-lNBGOhTkw7fiGCY");
		BotGramService service = new BotGramService(cfg);
		return service;
	}

}
