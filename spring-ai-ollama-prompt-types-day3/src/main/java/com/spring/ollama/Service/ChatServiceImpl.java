package com.spring.ollama.Service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.spring.ollama.entity.e1;

@Service 
public class ChatServiceImpl implements ChatService{
	
	private ChatClient chatClient;
	
	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatClient=builder.build();
	}
	//Fluent Api method
	  @Override public String flochat(String q) {
	String prompt="Code for Prime Number?";
	  
	  String content = chatClient 
			  .prompt(q) 
			  .user(prompt)
			  .system("In java code")
			  .call() 
			  .content();
	  
	  
	  return content; }
	 
	//Object method
	@Override
	public String objchat1() {
		String prompt = "Tell me what is methodOverloading?";
		
		Prompt prompt1 = new Prompt(prompt);
		var content = chatClient
			.prompt(prompt1)
			.call()
			.content();
		return content;
	}
	//Getting Metadata
	@Override
	public String metachat() {
		String prompt = " Tell me something about the Object method in java";
		Prompt prompt1 = new Prompt(prompt);
		var metadata = chatClient
				.prompt(prompt1)
				.call()
				.chatResponse()
				.getMetadata();
		System.out.println(metadata);
		return "";
	}
	
	@Override
	public e1 entitychat(String query) {
		//String prompt = "Tell me diffrence in Hashcode and Hashmap";
		Prompt prompt2 = new Prompt(query);
		e1 tutorial = chatClient
				.prompt(prompt2)
				.call()
				.entity(e1.class);
		return tutorial;
		
	}
	
	@Override
	public List<e1> listchat(String query) {
		Prompt prompt3 = new Prompt(query);
		List<e1> tutorial = chatClient
				.prompt(prompt3)
				.call()
				.entity(new ParameterizedTypeReference<List<e1>>() {
				});
		return tutorial;
	}
	
	
}
