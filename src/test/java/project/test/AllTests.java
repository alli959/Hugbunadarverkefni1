package project.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import project.controller.HomeControllerTest;
import project.controller.RegisterControllerTest;
import project.test.entities.PlayerTest;
import project.test.entities.TeamTest;
import project.test.entities.UserTest;

@RunWith(Suite.class)
@SuiteClasses({ApplicationTest.class , UserTest.class, HomeControllerTest.class, RegisterControllerTest.class,
	TeamTest.class, PlayerTest.class})

public class AllTests {

}