package com.aig.interview.project.usermanagement.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class User {
	@Id
	@Column
	
	private Long UUID;
	
	public Long getUUID() {
		return UUID;
	}
	public void setUUID(Long uUID) {
		UUID = uUID;
	}
	
	

	/*public User(Long uUID, String userName, String password, String confirm) {
		super();
		UUID = uUID;
		this.userName = userName;
		this.password = password;
		this.confirm = confirm;
	}
*/


	@Column	
	private String userName;
	
	@Column
	
	private String password;
	
@Column
	private String confirm;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonIgnore
	public String getConfirm() {
		return confirm;
	}
	@JsonProperty
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
}
