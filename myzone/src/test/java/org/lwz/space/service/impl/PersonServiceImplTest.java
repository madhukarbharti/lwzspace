package org.lwz.space.service.impl;

import org.junit.Test;
import org.lwz.space.dao.PersonDao;
import org.lwz.space.model.Genger;
import org.lwz.space.model.Person;
import org.lwz.space.service.PersonService;
import org.lwz.space.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class PersonServiceImplTest {

    @Test
    public void testSave() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "classpath:applicationContext.xml"
        });

        PersonService personService = applicationContext.getBean("personService", PersonService.class);

        Person person = new Person("xiaoquan", new Date(), Genger.MAN);
        personService.save(person);

//        PersonDao personDao = applicationContext.getBean("personDao", PersonDao.class);
//        System.out.println(personDao);

    }
}