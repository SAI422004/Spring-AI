package com.spring.ollama.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Aiconfig {
//	@Bean(name = "openAiChatClient")
//	public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
//		return ChatClient.builder(chatModel).build();
//		
//	}

	
	/*
	 * @Bean(name = "ollamaChatClient") public ChatClient
	 * ollamaChatModel(OllamaChatModel chatModel) { return
	 * ChatClient.builder(chatModel).build(); }
	 */
	 
	@Bean 
	public ChatClient chatClient(ChatClient.Builder builder) {
		return builder
				.defaultSystem("You are Senior Architect of Coding Laungages")
				.defaultOptions(OllamaChatOptions.builder()
					.model("deepseek-r1:latest")
					.temperature(0.3)
					.numPredict(1000)
					.build())
				.build();
	}

}
