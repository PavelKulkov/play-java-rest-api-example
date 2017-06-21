package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Test;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import services.TestService;

import javax.inject.Inject;


public class TestController extends Controller {


    private final TestService testService;

    @Inject
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Transactional
    public Result getAll() {
        return ok(Json.toJson(testService.getAll()));
    }

    @Transactional
    public Result create() {
        JsonNode json = request().body().asJson();
        testService.create(Json.fromJson(json,Test.class));
        return ok();
    }

    @Transactional
    public Result get(Long id) {
        return ok(Json.toJson(testService.get(id)));
    }

    @Transactional
    public Result update() {
        JsonNode json = request().body().asJson();
        return ok(Json.toJson(testService.update(Json.fromJson(json,Test.class))));
    }


}
