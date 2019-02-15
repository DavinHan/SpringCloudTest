package com.test.service.Impl;

import org.springframework.stereotype.Component;

import com.test.service.ISchedualServiceHi;

@Component
public class SchedualServiceHiImpl implements ISchedualServiceHi{

	@Override
	public String sayHiFromClient(String name) {
		return "sorry, " + name;
	}

}
