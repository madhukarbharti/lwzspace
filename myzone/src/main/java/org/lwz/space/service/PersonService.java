package org.lwz.space.service;

import org.lwz.space.model.Person;

import java.util.List;

/**
 * Created by xiaoQuan on 2014/12/21.
 */
public interface PersonService {
    void save(Person person);
    List<Person> list();
}
