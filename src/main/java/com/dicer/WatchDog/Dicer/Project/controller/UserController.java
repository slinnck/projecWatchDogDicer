package com.dicer.WatchDog.Dicer.Project.controller;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserDTO body) {
        return ResponseEntity.ok(userService.registerUser(body));
    }

    @GetMapping("/findByTaxpayernumber")
    public ResponseEntity<UserDTO> getUser(@RequestHeader HttpHeaders headers) {
        UserDTO userDTO = userService.getUserByTaxpayernumber(headers);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO>  userDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
}
