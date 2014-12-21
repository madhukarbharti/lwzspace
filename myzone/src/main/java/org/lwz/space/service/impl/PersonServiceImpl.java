package org.lwz.space.service.impl;

import org.lwz.space.dao.PersonDao;
import org.lwz.space.model.Person;
import org.lwz.space.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created by xiaoQuan on 2014/12/21.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        this.personDao.save(person);
    }

    @Override
    public List<Person> list() {
        return this.personDao.list();
    }
}
