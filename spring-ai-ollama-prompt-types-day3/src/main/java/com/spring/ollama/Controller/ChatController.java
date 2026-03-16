package com.spring.ollama.Controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ollama.Service.ChatService;
import com.spring.ollama.entity.e1;

@RestController
@RequestMapping
public class ChatController {
	/* private ChatClient chatClient; */
	private ChatService chatService;
	
	/*
	 * public ChatController(ChatClient.Builder chatClientBuilder) { this.chatClient
	 * = chatClientBuilder.build(); }
	 */
		public ChatController(ChatService chatService) {
			this.chatService = chatService;
		}
	
	@GetMapping("/flochat")
	public ResponseEntity<String> chat ( 
			@RequestParam(value = "q", required= true) String q ){
		String response = chatService.flochat(q);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/objchat")
	public ResponseEntity<String> chat1 (){
		String response = chatService.objchat1();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/metachat")
	public ResponseEntity<String> metachat() {
		String response = chatService.metachat();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/entitychat")
	public ResponseEntity<e1> entitychat(
			@RequestParam(value="query", required = true) String q){
		
		return ResponseEntity.ok(chatService.entitychat(q));
	}
	
	@GetMapping("/listchat")
	public ResponseEntity<List<e1>> listchat(
			@RequestParam(value="query", required = true) String q){
		return ResponseEntity.ok(chatService.listchat(q));
	}
}
