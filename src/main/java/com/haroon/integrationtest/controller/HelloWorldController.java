package com.haroon.integrationtest.controller;

@RestController
public class HelloWorldController {
	
	private final HelloWorldService helloWorldservice;
	
	public HelloWorldController(final HelloWorldService helloWorldService) {
		this.helloWorldservice = helloWorldService;
	}
	
	@GetMapping("hello")
	public String hello() {
		return helloWorldservice.hello();
	}

}
