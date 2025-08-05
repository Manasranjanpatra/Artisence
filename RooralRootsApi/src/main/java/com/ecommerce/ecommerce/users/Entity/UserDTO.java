package com.ecommerce.ecommerce.users.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String phone;
    private String role;
    private String password;
    private String profileimage;
    private String locality;
    private String pincode;
    private String city;
    private String state;
    private String district;
    private UserAdditional userAdditional;

    public UserDTO(User user){
        if(user.getId()!=null){
            this.id=user.getId();
        }
        this.name=user.getName();
        this.phone=user.getPhone();
        this.profileimage=user.getProfileimage();
        this.password=user.getPassword();
        this.locality=user.getLocality();
        this.pincode=user.getPincode();
        this.city=user.getCity();
        this.state=user.getState();
        this.district=user.getDistrict();
        this.userAdditional=user.getUserAdditional();
        this.role=user.getRole();
    }
}
