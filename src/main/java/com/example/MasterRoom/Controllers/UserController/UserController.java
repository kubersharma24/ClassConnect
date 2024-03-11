package com.example.MasterRoom.Controllers.UserController;

import com.example.MasterRoom.Model.Dtos.RequestDTOs.RegistrationDTO;
import com.example.MasterRoom.Model.Dtos.ResponseDTOs.ResgistrationResponse;
import com.example.MasterRoom.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegistrationDTO registrationDTO ){
        if(userService.checkFeilds(registrationDTO)){
            return new ResponseEntity<>(new ResgistrationResponse("Some field is missing"),HttpStatus.OK);
        }
        String status = userService.createNewUser(registrationDTO);
        return new ResponseEntity<>(new ResgistrationResponse(status),HttpStatus.OK);
    }
}
