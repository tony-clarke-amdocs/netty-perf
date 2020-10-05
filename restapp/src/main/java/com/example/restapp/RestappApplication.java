package com.example.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
public class RestappApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestappApplication.class, args);
    }

    @RequestMapping("/greeting")
    public void greeting() {
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void post(@RequestBody Map<?, ?> body) {
    }

}
