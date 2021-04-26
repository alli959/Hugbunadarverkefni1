package project.controller;


import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.Errors;

import project.Application;
import project.persistence.entities.Users;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import project.test.ApplicationTest;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RegisterControllerTest{
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	


	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
	}

	@Test
	public void registerGetTest() throws Exception {
		mockMvc.perform(get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("register"))
		.andExpect(forwardedUrl("/WEB-INF/jsp/register.jsp"));
				
	}
	
	@Test
	public void registerPostTestFail() throws Exception {
		Users user = new Users((long)100,"Tester","Tester1","12345","tester1@gmail.com");

	}
	@Test
	public void registerPostTestSuccess() throws Exception {
		
		Users user = new Users((long)100,"Tester","Tester1","12345","tester1@gmail.com");
		mockMvc.perform(post("/register")
				.secure( true )
		        .contentType("application/json")
		        .flashAttr("createUser", new Users())
		        .content(asJsonString(user)))
		.andExpect(view().name("redirect:login"))
		.andExpect(redirectedUrl("login"))
		.andExpect(status().isFound());
		 
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	
}
