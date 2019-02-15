package com.test.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

	@Value("${server.port}")
	String port;
	
	@RequestMapping("/client")
	public String home(@RequestParam(value = "name", defaultValue = "forezp")String name) {
		return "hi, I'm " + name + " , i am from port : " + port;
	}
}
