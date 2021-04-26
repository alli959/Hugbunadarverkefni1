package project.test.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import project.persistence.entities.Team;
import project.persistence.repositories.TeamRepository;
import project.service.TeamService;
import project.test.ApplicationTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamTest {

	@Autowired
	private TeamService service;
	
	@MockBean
	private TeamRepository repository;
	
	
	@Test
	public void getTeamTest() {
		when(repository.findAll()).thenReturn(Stream
				.of( new Team((long)100,"Tester1","Tester"), new Team((long)200,"Tester1","Tester")).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	public void getTeamByNameTest() {
		String teamName = "Tester1";
		when(repository.findByName(teamName)).thenReturn(Stream
				.of(new Team((long)200,"Tester1","Tester"),new Team((long)202, "Tester1", "Tester")).collect(Collectors.toList()));
		assertNotNull(service.findByName(teamName));
				
	}
	@Test
	public void saveTeamTest() {
		Team team = new Team((long)100,"Tester1","Tester");
		when(repository.save(team)).thenReturn(team);
		assertEquals(team, service.save(team));
	}
	@Test
	public void deleteTeamTest() {
		Team team = new Team((long)100,"Tester1","Tester");
		//Delete user
		service.delete(team);
		verify(repository, times(1)).delete(team);
	}
	
	
	
	
}
