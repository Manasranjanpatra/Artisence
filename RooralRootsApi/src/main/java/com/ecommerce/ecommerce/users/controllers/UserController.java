package com.ecommerce.ecommerce.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.global.LoginDTO;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.users.Entity.UserDTO;
import com.ecommerce.ecommerce.users.Entity.UserFetchPojo;
import com.ecommerce.ecommerce.users.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<UserFetchPojo> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public UserFetchPojo getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/info")
    public UserFetchPojo getAuthUserInfo() {
        return userService.getAuthUserInfo();
    }

    @PostMapping(value = "/saveorupdate")
    public Status saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveOrUpdate(userDTO);
    }

    @PostMapping(value = "/update")
    public Status updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public Status deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @PostMapping("/signin")
    public Status userLogin(@RequestBody LoginDTO logDto) {
        return userService.userLogin(logDto);
    }

    @PostMapping(value = "/profile")
    public Status updateProfile(@RequestPart("file") MultipartFile file) {
        return userService.updateProfile(file);
    }

}
