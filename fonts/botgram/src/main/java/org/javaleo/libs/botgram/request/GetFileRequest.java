package org.javaleo.libs.botgram.request;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFileRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("file_id")
	private String fileId;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
