package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatPermissions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("can_send_messages")
	private Boolean canSendMessages;

	@Expose
	@SerializedName("can_send_media_messages")
	private Boolean canSendMediaMessages;

	@Expose
	@SerializedName("can_send_polls")
	private Boolean canSendPolls;

	@Expose
	@SerializedName("can_send_other_messages")
	private Boolean canSendOtherMessages;

	@Expose
	@SerializedName("can_add_web_page_previews")
	private Boolean canAddWebPagePreviews;

	@Expose
	@SerializedName("can_change_info")
	private Boolean canChangeInfo;

	@Expose
	@SerializedName("can_invite_users")
	private Boolean canInviteUsers;

	@Expose
	@SerializedName("can_pin_messages")
	private Boolean canPinMessages;

}
