package com.Beom.app.ajax;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RestTempleTest {
	
	//inner => java GUI
	
	public void flux()throws Exception{
		WebClient webClient = WebClient.builder()
						.baseUrl("https://jsonplaceholder.typicode.com/")
						.build();
		int num = 1;
//		Mono<ResponseEntity<RestVO>> res = webClient.get()
//												.uri("/posts/1")
//												.retrieve()
//												.toEntity(RestVO.class);
//		
//		RestVO restVO = res.block().getBody();

//		Mono<RestVO> res = webClient.get()
//									.uri("/posts/1")
//									.retrieve()
//									.bodyToMono(RestVO.class);
//		RestVO restVO =res.block();
//		0개 또는 한개만 가져올때
		
		Flux<RestVO> res = webClient.get()
									.uri("/posts")
									.retrieve()
									.bodyToFlux(RestVO.class);
		
		res.subscribe((r)->{
			RestVO restVO = r;
			log.info("{}",restVO);
		});

		
		
				
	}
	
	public void rest()throws Exception{
		log.info("RestTemplete");
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(null, null); 
		
		ResponseEntity<RestVO> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", RestVO.class);
		
		RestVO result = response.getBody();
		
		log.info("{}",result);
		
	}
	
}
