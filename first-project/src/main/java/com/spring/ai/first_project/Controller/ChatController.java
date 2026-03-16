package com.spring.ai.first_project.Controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class ChatController {
	
	
	private ChatClient chatClient ; //here we cannot do autowire beacouse It doesnot create the bean automatically 
	//SO we create a builder class and we will get the bean of the builder class
	public ChatController(ChatClient.Builder builder) { //ya madhe apan chatclient build kela pn 
		//chatclient.builder class te spring ai ne build kela ee
		this.chatClient = builder.build();
	}
	
	@GetMapping("/chat")
	public ResponseEntity<String> chat(
		@RequestParam(value = "q", required = true) String q
	){
		var resultResponse = this.chatClient.prompt(q).call().content();
		return ResponseEntity.ok(resultResponse);
	}
}
