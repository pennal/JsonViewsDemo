package org.lp.viewTest.controllers;

import org.lp.viewTest.models.SomeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    public SomeEntity getEntity() {
        SomeEntity entity = new SomeEntity();
        entity.setId(1);
        entity.setBaseInfo("This is the base info");
        entity.setUserInfo("This is the user info");
        entity.setSecretInfo("This is the secret info");
        return entity;
    }

    @GetMapping
    public ResponseEntity getBasic(@RequestParam(required = false) String view) {

        return ResponseEntity.ok(getEntity());
    }

}
