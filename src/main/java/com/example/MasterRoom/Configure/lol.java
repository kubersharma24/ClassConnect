package com.example.MasterRoom.Configure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/home")
public class lol {
    @GetMapping("/user")
    public ResponseEntity<?> createUser(){
        return new ResponseEntity<>("hello",HttpStatus.OK);
    }
}
