package kr.co.greenpai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloubService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloubService1Application.class, args);
    }

}
