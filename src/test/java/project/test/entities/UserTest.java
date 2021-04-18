package project.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import project.persistence.entities.Users;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import project.test.ApplicationTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of( new Users((long)100,"Tester","Tester1","12345","Tester1@gmail.com"), new Users((long)200,"Tester","Tester2","12345","Tester2@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	public void getUsersByUserNameTest() {
		String userName = "Tester1";
		when(repository.getByUserName(userName)).thenReturn(new Users((long)200,"Tester","Tester1","12345","Tester2@gmail.com"));
		assertNotNull(service.getByUserName(userName));
				
	}
	@Test
	public void saveUserTest() {
		Users user = new Users((long)100,"Tester","Tester1","12345","Tester1@gmail.com");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.save(user));
	}
	@Test
	public void deleteUserTest() {
		Users user = new Users((long)100,"Tester","Tester1","12345","Tester1@gmail.com");
		//Delete user
		service.delete(user);
		verify(repository, times(1)).delete(user);
	}
	
	
	
	
}
