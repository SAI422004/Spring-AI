package com.spring.ollama.Service;

import java.util.List;

import com.spring.ollama.entity.e1;

public interface ChatService {
	String flochat (String query);
	String objchat1();
	String metachat();
	e1 entitychat(String query);
	List<e1> listchat(String query);
	
} 
