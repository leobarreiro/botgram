package org.javaleo.libs.botgram.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.gabro3.libs.botgram.exceptions.BotGramException;
import com.gabro3.libs.botgram.model.Document;
import com.gabro3.libs.botgram.model.Message;
import com.gabro3.libs.botgram.model.PhotoSize;
import com.gabro3.libs.botgram.model.Update;
import com.gabro3.libs.botgram.request.SendDocumentRequest;
import com.gabro3.libs.botgram.request.SendMessageRequest;
import com.gabro3.libs.botgram.response.GetFileResponse;
import com.gabro3.libs.botgram.response.GetMeResponse;
import com.gabro3.libs.botgram.response.GetUpdatesResponse;
import com.gabro3.libs.botgram.response.SendDocumentResponse;
import com.gabro3.libs.botgram.response.SendMessageResponse;
import com.gabro3.libs.botgram.service.BotGramConfig;
import com.gabro3.libs.botgram.service.BotGramService;

@RunWith(JUnitPlatform.class)
public class BotGramServiceTest {

	@Test
	public void getMeTest() throws Exception {
		startTest();
		System.out.println("GetMeTest");
		BotGramService service = buildService();
		GetMeResponse response;
		try {
			response = service.getMe();
			assertTrue(response.getOk());
			assertNotNull(response.getUser());
			System.out.println(response.getUser().getUsername());
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	@Test
	public void getUpdatesTest() throws Exception  {
		startTest();
		System.out.println("GetUpdatesTest");
		BotGramService service = buildService();
		GetUpdatesResponse response;
		try {
			response = service.getUpdates(0, 10);
			assertTrue(response.getOk());
			response.getUpdates().forEach(upd -> {
				System.out.println(upd.getId());
				System.out.println(upd.getMessage().getFrom().getUsername());
				System.out.println(upd.getMessage().getText());
			});
			
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	@Test
	public void sendMessageTest() throws Exception  {
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
				assertTrue(messageResponse.getOk());
			} else {
				System.out.println("Nenhum update disponivel.");
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	//@Test
	public void getPhotoTest() throws Exception  {
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
					assertTrue(response.getOk());
				}
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	//@Test
	public void getDocumentTest() throws Exception  {
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
					assertTrue(response.getOk());
				}
			}
		} catch (BotGramException e) {
			e.printStackTrace();
		}
		endTest();
	}

	public void sendDocumentTest() throws Exception  {
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
				assertTrue(response.getOk());
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
		cfg.setToken("1754137351:AAFPVam8rGjhuBZAN-86fc91StPkRwo5O7o");
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
