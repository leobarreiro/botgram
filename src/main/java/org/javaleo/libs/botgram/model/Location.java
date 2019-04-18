package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("longitude")
	private Float longitude;

	@Expose
	@SerializedName("latitude")
	private Float latitude;

}
