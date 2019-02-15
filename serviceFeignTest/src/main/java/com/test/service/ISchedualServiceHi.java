package com.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.service.Impl.SchedualServiceHiImpl;

@FeignClient(value = "eureka-server", fallback = SchedualServiceHiImpl.class)
public interface ISchedualServiceHi {
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	String sayHiFromClient(@RequestParam(value = "name") String name);
}
