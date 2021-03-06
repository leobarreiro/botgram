package com.gabro3.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("longitude")
	private Float longitude;

	@Expose
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
