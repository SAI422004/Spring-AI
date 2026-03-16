package com.spring.ollama.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
	private ChatClient chatClient;
	private ChatClient ollamaChatClient;
	private ChatClient openAiChatClient;
	
	// This we were doing it manually for autowired but we have made the config file so we dont ned to this we can create constructore and call it 
//	public ChatController(OllamaChatModel ollamaChatModel , OpenAiChatModel openAiChatModel ) {
//		this.ollamaChatClient=ChatClient.builder(ollamaChatModel).build();
//		this.openAiChatClient=ChatClient.builder(openAiChatModel).build();
//		
//	}
	// Just this beacouse we have made the config file
	public ChatController(@Qualifier("openAiChatClient")ChatClient openAiChatClient ,
			@Qualifier("ollamaChatClient")ChatClient ollamaChatClient) {
		this.openAiChatClient = openAiChatClient;
		this.ollamaChatClient = ollamaChatClient;
	}
	@GetMapping("/chat")
	public ResponseEntity<String> chat ( 
			@RequestParam(value = "q", required= true) String q ){
		var resultResponse = this.ollamaChatClient
				.prompt(q)
				.call()
				.content();
		return ResponseEntity.ok(resultResponse);
		
	}
	
}
