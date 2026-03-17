package com.spring.ollama.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ollama.Service.ChatService;
import com.spring.ollama.Entity.e1;

@RestController
@RequestMapping
public class ChatController {
	
	private ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@GetMapping("/chat")
	public ResponseEntity<String> chat(
			@RequestParam(value="query", required=true) String q){
		return ResponseEntity.ok(chatService.chat(q));
	}
	
	@GetMapping("/entitychat")
	public ResponseEntity<e1> chatTemplate(@RequestParam(value="query", required=true) String q){
		return ResponseEntity.ok(chatService.chatTemplate(q));
	}
	
}
