package com.haroon.integrationtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.haroon.integrationtest.controller.HelloWorldController;
import com.haroon.integrationtest.service.HelloWorldService;

@WebMvcTest(HelloWorldController.class)
@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HelloWorldService service;
	
	@Test
	public void shouldReturnHello() throws Exception{
		when(service.hello()).thenReturn("Hello World");
		
		mockMvc.perform(get("/hello").contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello World"));
	}

}
