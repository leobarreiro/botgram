package org.javaleo.libs.botgram.model;

import java.io.Serializable;

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
public class BotGramHttpResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String protocol;
	private String content;

}
