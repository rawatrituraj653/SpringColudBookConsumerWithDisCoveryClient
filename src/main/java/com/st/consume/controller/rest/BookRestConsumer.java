package com.st.consume.controller.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/rest")
public class BookRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/msg")
	public String getMsg() {
		
		List<ServiceInstance> list=client.getInstances("Universal_Book_Store");
		ServiceInstance instance= list.get(0);
		URI uri=instance.getUri();
		String URL=uri+"/book/getall";
		
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> entity=template.getForEntity(URL, String.class);
			String body=entity.getBody();
			
		return "consumer: "+body;
	}
	
	@GetMapping("/getData/{name}")
	public String getBookByName(@PathVariable String name) {
		List<ServiceInstance> list=client.getInstances("Universal_Book_Store");
		ServiceInstance instance= list.get(0);
		URI uri=instance.getUri();
		String URL=uri+"/book/getbookbyname/"+name;
		
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> entity=template.getForEntity(URL, String.class);
		String body=entity.getBody();
			return "Data Comes From Producer "+body;
	}
}
