package com.spring.ollama.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
	//we donot use Autowired here beacouse from spring 4.3 onward if a class has 1 constructorinjection
	//then spring automatically inject the dependency
	private ChatClient chatClient;
	//It is 
	public ChatController (ChatClient.Builder builder) {
		
		this.chatClient = builder.build();
		System.out.println(chatClient.getClass().getName());
	}
	
	
	
	@GetMapping("/chat")
	public ResponseEntity<String> chat(
			@RequestParam(value = "q" ,required = true ) String query)
	{
		String responseContent = this .chatClient.prompt(query) // prompt is method where we will be passing the query as a string
				.call() // It is a method to call the llm or chat api
				.content(); //It is use to show the result 
		return ResponseEntity.ok(responseContent);
	}

}

