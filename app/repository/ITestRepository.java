package repository;

import models.Test;

import java.util.List;


public interface ITestRepository {

    List<Test> list();

    void create(Test t);

    Test get(Long id);

    Test update(Test t);
}
