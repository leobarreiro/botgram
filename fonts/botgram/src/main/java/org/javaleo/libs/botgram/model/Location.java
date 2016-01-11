package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("longitude")
	private Float longitude;
	
	@SerializedName("latitude")
	private Float latitude;

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

}
