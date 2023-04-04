package com.dicer.WatchDog.Dicer.Project.controller;

import com.dicer.WatchDog.Dicer.Project.dto.UserDTO;
import com.dicer.WatchDog.Dicer.Project.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Register of users", notes = "Api used for register users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User registered with sucsess")
    })
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserDTO body) {
        return ResponseEntity.ok(userService.registerUser(body));
    }

    @ApiOperation(value = "Find User By Taxpayernumber", notes = "Api used for find users by taxpayernumber")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User founded")
    })
    @GetMapping("/findByTaxpayernumber")
    public ResponseEntity<UserDTO> getUser(@RequestHeader HttpHeaders headers) {
        UserDTO userDTO = userService.getUserByTaxpayernumber(headers);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Find all users", notes = "Api used for find all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users founded")
    })
    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO>  userDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

//    @ApiOperation(value = "Update User", notes = "Api used for update user")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "User was updated with success")
//    })
//    public ResponseEntity<UserDTO> updateUser(@RequestHeader HttpHeaders headers, @RequestBody UserDTO body) {
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
