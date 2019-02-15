package com.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.ISchedualServiceHi;

@RestController
public class HiController {

	@Autowired
	ISchedualServiceHi schedualServiceHi;
	
	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam String name) {
		return schedualServiceHi.sayHiFromClient(name);
	}
}
