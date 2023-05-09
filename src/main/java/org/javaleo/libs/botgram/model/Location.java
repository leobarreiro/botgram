package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float longitude;

	private Float latitude;

}
