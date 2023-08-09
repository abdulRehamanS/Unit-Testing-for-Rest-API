package com.example.demo.Controller;


import com.example.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class userController {

   @Autowired
   userService service;

    @GetMapping("/welcome")
    public ResponseEntity<String> getMsg() {
        String msg = service.getuserName();
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
