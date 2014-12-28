package org.lwz.space.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lwz.space.dao.PersonDao;
import org.lwz.space.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoQuan on 2014/12/21.
 */

/**
 * 仅仅是Demo，自己封装BaseDao,以及学习HQL
 */

@Repository(value = "personDao")
public class PersonDaoImpl implements PersonDao {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void save(Person person) {
        //TODO getCurrentSession()
        this.sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public List<Person> list() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Person");
        return query.list();
    }

    @Override
    public Person get(Integer id) {
        //TODO
        return null;
    }
}
