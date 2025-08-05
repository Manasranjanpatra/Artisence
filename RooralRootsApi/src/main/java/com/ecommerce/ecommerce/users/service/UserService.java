package com.ecommerce.ecommerce.users.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.global.LoginDTO;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.users.Entity.UserDTO;
import com.ecommerce.ecommerce.users.Entity.UserFetchPojo;

public interface UserService {

    
    List<UserFetchPojo> findAll();

    UserFetchPojo getById(Long id);

    Status saveOrUpdate(UserDTO userDTO);

    Status deleteById(Long id);

    Status userLogin(LoginDTO logDto);

    Status updateProfile(MultipartFile file);

    UserFetchPojo getAuthUserInfo();

    Status updateUser(UserDTO userDTO);
    
}
