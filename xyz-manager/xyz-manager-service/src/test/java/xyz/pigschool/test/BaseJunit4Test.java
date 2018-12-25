package xyz.pigschool.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"/spring/applicationContext.xml",
		"/mybatis/SqlMapConfig.xml"})
public class BaseJunit4Test {

}
