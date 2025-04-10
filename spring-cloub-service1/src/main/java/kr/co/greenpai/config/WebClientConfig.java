package kr.co.greenpai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/*
* 다른 서비스에 요청을 보내는 객체다.
* */
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient getWebClient(WebClient.Builder webClientbuilder) {

        return webClientbuilder
                .baseUrl("http://localhost:8082/service2")
                .build();
    }
}
