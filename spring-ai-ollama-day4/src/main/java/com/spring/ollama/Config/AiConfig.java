package com.spring.ollama.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {
		return builder
				.defaultOptions(OllamaChatOptions.builder()
						.model("codellama:latest")
						.temperature(0.3)
						.numPredict(500)
						.build())
				.build();
		
	}
	
}
