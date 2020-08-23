package com.fin.stock.stockanalysismicroservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.fin.stock.stockanalysismicroservice")
@EnableDiscoveryClient
public class StockAnalysisMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAnalysisMicroserviceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
