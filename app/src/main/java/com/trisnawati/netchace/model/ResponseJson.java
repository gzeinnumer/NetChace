package com.trisnawati.netchace.model;

import com.google.gson.annotations.SerializedName;

public class ResponseJson{

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("userId")
	private int userId;

	//todo 11 constructor
	public ResponseJson(int id, String title, String body, int userId) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	//end todo
	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}
}