package com.mycomp.business.krishi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthControlller {

	@RequestMapping(method = RequestMethod.GET)
	public String checkHealth() {
		return "ACTIVE";
	}
}
