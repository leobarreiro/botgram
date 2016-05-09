package org.javaleo.libs.botgram.service;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.Document;
import org.javaleo.libs.botgram.model.Message;
import org.javaleo.libs.botgram.model.PhotoSize;
import org.javaleo.libs.botgram.model.TelegramFile;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetFileResponse;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;
import org.junit.Test;

public class BotGramServiceTest {

	public void getMeTest() {
		startTest();
		System.out.println("GetMeTest");
		BotGramService service = buildService();
		GetMeResponse response;
		try {
			response = service.getMe();
			assertTrue("GetMe Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	public void getUpdatesTest() {
		startTest();
		System.out.println("GetUpdatesTest");
		BotGramService service = buildService();
		GetUpdatesResponse response;
		try {
			response = service.getUpdates(0, 10);
			assertTrue("GetUpdates Response", response.getOk());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	public void sendMessageTest() {
		startTest();
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
		endTest();
	}

	@Test
	public void getPhotoTest() {
		startTest();
		System.out.println("GetFileTest");
		BotGramService service = buildService();
		try {
			Update update = getLastUpdateSupport();
			if (update != null) {
				List<PhotoSize> photoSizes = update.getMessage().getPhotosizes();
				if (photoSizes != null && !photoSizes.isEmpty()) {
					PhotoSize firstPhotoSize = photoSizes.get(0);
					GetFileResponse response = service.getFile(firstPhotoSize.getId());
					String urlDownload = service.getFileUrlDownload(response.getFile().getPath());
					System.out.println(urlDownload);
					assertTrue(response.getFile().getPath(), response.getOk());
				} else {
					assertTrue("Nenhuma foto disponivel.", true);
				}
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}
	
	@Test
	public void getDocumentTest() {
		startTest();
		System.out.println("GetDocumentTest");
		BotGramService service = buildService();
		try {
			Update update = getLastUpdateSupport();
			if (update != null) {
				Message message = update.getMessage();
				if (message.getDocument() != null) {
					Document document = message.getDocument();
					GetFileResponse response = service.getFile(document.getId());
					String urlDownload = service.getFileUrlDownload(response.getFile().getPath());
					System.out.println(urlDownload);
					assertTrue(urlDownload, response.getOk());
				} else {
					assertTrue("Nenhum documento disponivel.", true);
				}
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	public void sendDocumentTest() {
		startTest();
		System.out.println("SendDocumentTest");
		BotGramService service = buildService();
		try {
			Update update = getLastUpdateSupport();
			if (update != null) {
				SendDocumentRequest request = new SendDocumentRequest();
				request.setChatId(update.getMessage().getChat().getId());
				request.setFileName("C:\\Users\\Administrador\\Downloads\\yamahaVirago535.jpg");
				SendDocumentResponse response = service.sendDocument(request);
				assertTrue(response.getDescription(), response.getOk());
			} else {
				System.out.println("Nenhum update disponivel.");
				assertTrue("Requisicao de sendDocument foi realizada mas nao existe nenhum update.", true);
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
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
		cfg.setToken("192600232:AAHKJ3rDzDVhMzGgUbg08Z2TNangduXm3b4");
		BotGramService service = new BotGramService(cfg);
		return service;
	}

	private void startTest() {
		System.out.println("- - - Start Test - - -");
	}
	
	private void endTest() {
		System.out.println("- - - End Test - - -");
	}
	
}
