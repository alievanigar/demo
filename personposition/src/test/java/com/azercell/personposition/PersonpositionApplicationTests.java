package com.azercell.personposition;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonpositionApplicationTests {

	@Test
	void contextLoads() {
		SkillDaoImplTest.setUp();

		SkillDaoImplTest sk = new SkillDaoImplTest();
		sk.before();
	}

}
