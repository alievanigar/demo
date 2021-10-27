package com.azercell.personposition;

import com.azercell.personposition.dao.impl.SkillDaoImpl;
import com.azercell.personposition.dao.inter.SkillDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
    class SkillDaoImplTest {
        @Mock
        SkillDaoInter skillDao;

        @InjectMocks
        SkillDaoImpl skillDaoImpl;

        @BeforeTestClass
        public static void setUp(){
            System.out.println("set up called");
        }
        @Before("")
        public void before(){
            System.out.println("before called");
            MockitoAnnotations.initMocks(this);
            List<SkillDTO> list = new ArrayList<>();
            SkillDTO u = new SkillDTO();
            u.setName("test");
            list.add(u);
            Mockito.when(skillDao.getById(null)).thenReturn(null);
            Mockito.when(skillDao.getById(1L)).thenReturn((SkillDTO) list);

        }
}
