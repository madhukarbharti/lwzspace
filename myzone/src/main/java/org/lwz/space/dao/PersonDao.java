package org.lwz.space.dao;

import org.lwz.space.model.Person;

import java.util.List;

/**
 * Created by xiaoQuan on 2014/12/21.
 */
public interface PersonDao {
    public void save(Person person);
    public List<Person> list();
    public Person get(Integer id);
}
