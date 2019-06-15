package com.whm.First_SpringBoot_M2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.whm.First_SpringBoot_M3.Controller.EController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstSpringBootM2ApplicationTests {
private MockMvc mvc;
//在测试之前给mvc知道要测试哪一个controller类
@Before
public void setup() throws Exception{
	 mvc=MockMvcBuilders.standaloneSetup(new EController()).build();
}
	@Test
	public void contextLoads() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/MyTest/hello"));	
	}

}
