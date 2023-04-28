package pl.mw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Collections;

//https://www.javainuse.com/spring/cloud-gateway-eureka
// dokumentacja: https://cloud.spring.io/spring-cloud-gateway/reference/html/#verbose-actuator-format
// http://localhost:8080/actuator/gateway/routes

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
