package repository;

import models.Test;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton

public class TestRepositoryImpl implements ITestRepository {


    private final JPAApi jpaApi;

    @Inject
    public TestRepositoryImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }


    @Transactional
    @Override
    public List<Test> list() {
        TypedQuery<Test> query = jpaApi.em().createQuery("select t from Test t", Test.class);
        return query.getResultList();
    }

    @Override
    public void create(Test test) {
        jpaApi.em().persist(test);
    }

    @Override
    public Test get(Long id) {
        return jpaApi.em().find(Test.class,id);
    }

    @Override
    public Test update(Test test) {
        return jpaApi.em().merge(test);
    }
}
