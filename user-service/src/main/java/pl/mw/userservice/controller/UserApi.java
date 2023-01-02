package pl.mw.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @GetMapping("/hello")
    public String hello(){
        return "Hello from UserApi";
    }
}