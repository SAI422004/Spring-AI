package com.spring.ollama.Entity;

public class e1 {
	private String title;
	private String content;
	private String CreatedAt;
	public e1(String title, String content, String createdAt) {
		this.title = title;
		this.content = content;
		CreatedAt = createdAt;
	}
	public e1() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	
	
	
	
	
}
