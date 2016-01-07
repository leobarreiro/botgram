package org.javaleo.libs.botgram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = IBotGramPojo.SCHEMA, name = "user")
public class User implements IBotGramPojo {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;

	@Id
	@GeneratedValue
	@Column(name="user_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
