package org.javaleo.libs.botgram.service;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;
import org.junit.Test;

public class BotGramServiceTest {

	@Test
	public void getMeTest() {
		System.out.println("- - - - - - - - - -");
		System.out.println("GetMeTest");
		BotGramService service = buildService();
		GetMeResponse response;
		try {
			response = service.getMe();
			assertTrue("GetMe Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		System.out.println("- - - - - - - - - -");
	}

	@Test
	public void getUpdatesTest() {
		System.out.println("- - - - - - - - - -");
		System.out.println("GetUpdatesTest");
		BotGramService service = buildService();
		GetUpdatesResponse response;
		try {
			response = service.getUpdates(0, 10);
			assertTrue("GetUpdates Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		System.out.println("- - - - - - - - - -");
	}

	@Test
	public void sendMessageTest() {
		System.out.println("- - - - - - - - - -");
		System.out.println("SendMessageTest");
		BotGramService service = buildService();
		try {
			Update update = getLastUpdateSupport();
			if (update != null) {
				SendMessageRequest request = new SendMessageRequest();
				request.setChatId(update.getMessage().getChat().getId());
				request.setText(Calendar.getInstance().getTime().toString());
				SendMessageResponse messageResponse = service.sendMessage(request);
				assertTrue(messageResponse.getDescription(), messageResponse.getOk());
			} else {
				System.out.println("Nenhum update disponivel.");
				assertTrue("Requisicao de sendMessage foi realizada mas nao existe nenhum update.", true);
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		System.out.println("- - - - - - - - - -");
	}

	@Test
	public void sendDocumentTest() {
		System.out.println("- - - - - - - - - -");
		System.out.println("SendDocumentTest");
		BotGramService service = buildService();
		try {
			Update update = getLastUpdateSupport();
			if (update != null) {
				SendDocumentRequest request = new SendDocumentRequest();
				request.setChatId(update.getMessage().getChat().getId());
				request.setFileName("/home/leo/Downloads/react-essentials.pdf");
				SendDocumentResponse response = service.sendDocument(request);
				assertTrue(response.getDescription(), response.getOk());
			} else {
				System.out.println("Nenhum update disponivel.");
				assertTrue("Requisicao de sendDocument foi realizada mas nao existe nenhum update.", true);
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		System.out.println("- - - - - - - - - -");
	}

	private Update getLastUpdateSupport() throws BotGramException {
		BotGramService service = buildService();
		GetUpdatesResponse response = service.getUpdates(0, 10);
		List<Update> updates = response.getUpdates();
		if (updates != null && !updates.isEmpty()) {
			return updates.get(updates.size() - 1);
		}
		return null;
	}

	private BotGramService buildService() {
		BotGramConfig cfg = new BotGramConfig();
		// @MinhaSaudeBot
		cfg.setToken("143190108:AAHO8fKsnY85RsnoVN8-lNBGOhTkw7fiGCY");
		BotGramService service = new BotGramService(cfg);
		return service;
	}

}
