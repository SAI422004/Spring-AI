package com.spring.ollama.Service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Service;

import com.spring.ollama.Entity.e1;



//import com.spring.ollama.entity.e1;

@Service
public class ChatServiceImpl implements ChatService {
	
	private ChatClient chatClient;
	
	public ChatServiceImpl(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	//Prompt templating with fluent API using lambda
	/*
	 * @Override public String chat(String query) { // String prompt =
	 * "Tell me diffrence in Hashcode and Hashmap";
	 * 
	 * Prompt prompt = new Prompt(query); String queryStr
	 * =" As an expert in the coding and programming. Always write program in java. Now reply for this question :{query}"
	 * ; var tutorials = chatClient .prompt() .user( u ->
	 * u.text(queryStr).param("query",query)) .call() .content(); return tutorials;
	 * 
	 * }
	 */
	
	@Override
	public e1 chatTemplate(String query) {
		//first step
		PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName}? temm me example of {exampleName}").build();
		//render the template 
		String renderedMessage = strTemplate.render(Map.of( 
				"techName","Java",
				"exampleName","Spring Exception"
				));
		Prompt prompt = new Prompt(renderedMessage);
		return this.chatClient.prompt(prompt).call().entity(e1.class);
		
	}
	
	//Specific Role Prompt Template
	@Override
	public String chat(String query) {
	SystemPromptTemplate systemPromptTemplate = SystemPromptTemplate.builder()
	.template("You are a helpful coding assistant. You are an expert in coding")
	.build();
	
	Message systemMessage = systemPromptTemplate.createMessage();
	
	var userPromptTemplate = PromptTemplate.builder().template("What is {techName}? "
			+ "temm me example of {exampleName}").build();
	Message userMessage = userPromptTemplate.createMessage(Map.of(
			"techName","Java",
			"exampleName","Spring Exception"
			));
	
	Prompt prompt = new Prompt(systemMessage,userMessage);
	
	return this.chatClient.prompt(prompt).call().content();
	}
	
	
	
}
