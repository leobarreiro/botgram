package org.javaleo.libs.botgram.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.javaleo.libs.botgram.exceptions.BotGramException;
import org.javaleo.libs.botgram.model.Document;
import org.javaleo.libs.botgram.model.Message;
import org.javaleo.libs.botgram.model.PhotoSize;
import org.javaleo.libs.botgram.model.Update;
import org.javaleo.libs.botgram.request.SendDocumentRequest;
import org.javaleo.libs.botgram.request.SendMessageRequest;
import org.javaleo.libs.botgram.response.GetFileResponse;
import org.javaleo.libs.botgram.response.GetMeResponse;
import org.javaleo.libs.botgram.response.GetUpdatesResponse;
import org.javaleo.libs.botgram.response.SendDocumentResponse;
import org.javaleo.libs.botgram.response.SendMessageResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class BotGramServiceTest {

	@Test
	void getMeTest() throws Exception {
		log.info("GetMeTest");
		BotGramService service = buildService();
		GetMeResponse response;
		response = service.getMe();
		assertTrue(response.getOk());
		assertNotNull(response.getUser());
		log.info(response.getUser().getUsername());
	}

	@Test
	void getUpdatesTest() throws Exception  {
		log.info("GetUpdatesTest");
		BotGramService service = buildService();
		GetUpdatesResponse response;
		response = service.getUpdates(0, 10);
		assertTrue(response.getOk());
		response.getUpdates().forEach(upd -> {
			log.info(upd.getId().toString());
			log.info(upd.getMessage().getFrom().getUsername());
			log.info(upd.getMessage().getText());
		});
	}

	@Test
	void sendMessageTest() throws Exception  {
		log.info("SendMessageTest");
		BotGramService service = buildService();
		Update update = getLastUpdateSupport();
		if (update != null) {
			SendMessageRequest request = new SendMessageRequest();
			request.setChatId(update.getMessage().getChat().getId());
			request.setText(Calendar.getInstance().getTime().toString());
			SendMessageResponse messageResponse = service.sendMessage(request);
			assertTrue(messageResponse.getOk());
		} else {
			log.info("Nenhum update disponivel.");
		}
	}

	@Test
	void getPhotoTest() throws Exception {
		log.info("GetFileTest");
		BotGramService service = buildService();
		Update update = getLastUpdateSupport();
		if (update != null) {
			List<PhotoSize> photoSizes = update.getMessage().getPhotosizes();
			if (photoSizes != null && !photoSizes.isEmpty()) {
				PhotoSize firstPhotoSize = photoSizes.get(0);
				GetFileResponse response = service.getFile(firstPhotoSize.getId());
				String urlDownload = service.getFileUrlDownload(response.getFile().getPath());
				log.info(urlDownload);
				assertTrue(response.getOk());
			}
		}
	}

	@Test
	void getDocumentTest() throws Exception  {
		log.info("GetDocumentTest");
		BotGramService service = buildService();
		Update update = getLastUpdateSupport();
		if (update != null) {
			Message message = update.getMessage();
			if (message.getDocument() != null) {
				Document document = message.getDocument();
				GetFileResponse response = service.getFile(document.getId());
				String urlDownload = service.getFileUrlDownload(response.getFile().getPath());
				log.info(urlDownload);
				assertTrue(response.getOk());
			}
		}
	}

	@Test
	void sendDocumentTest() throws Exception {
		log.info("SendDocumentTest");
		BotGramService service = buildService();
		Update update = getLastUpdateSupport();
		if (update != null) {
			SendDocumentRequest request = new SendDocumentRequest();
			request.setChatId(update.getMessage().getChat().getId());
			request.setFileName("./src/main/resources/pictures/01-metallic-red.png");
			SendDocumentResponse response = service.sendDocument(request);
			assertTrue(response.getOk());
		}
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
		cfg.setToken(System.getenv("TELEGRAM_TOKEN"));
		BotGramService service = new BotGramService(cfg);
		return service;
	}

	@BeforeAll
	static void startTest() {
		log.info("Test started");
	}

	@AfterAll
	static void endTest() {
		log.info("Test finished");
	}

}
