package services;

import models.*;
import repository.TestRepositoryImpl;


import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestService {

    private final TestRepositoryImpl testRepository;

    @Inject
    public TestService(TestRepositoryImpl testRepository) {
        this.testRepository = testRepository;
    }


    public List<Test> getAll() {
        return testRepository.list();
    }


    public void create(Test test) {
        testRepository.create(test);
    }

    public Test get(Long id){
        return testRepository.get(id);
    }

    public Test update(Test test) {
        return testRepository.update(test);
    }

    public TestResult checkTest(TestFromClient testFromClient) {
        Set<Question> questions = testRepository.get(testFromClient.testId).getQuestions();
        Map<Long,List<Long>> answers = testFromClient.answers;

        for(Question question : questions) {

        }

    }
}
