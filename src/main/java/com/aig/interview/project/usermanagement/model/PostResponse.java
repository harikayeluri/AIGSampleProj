package com.aig.interview.project.usermanagement.model;

import java.util.List;

import org.springframework.data.domain.Page;

public class PostResponse {
	
	private int count;
	private int paging;
	private List<User> userList;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPaging() {
		return paging;
	}
	public void setPaging(int paging) {
		this.paging = paging;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> list) {
		this.userList = list;
	}

	

}
