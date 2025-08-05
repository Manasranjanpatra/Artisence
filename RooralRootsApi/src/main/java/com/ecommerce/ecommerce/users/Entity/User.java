package com.ecommerce.ecommerce.users.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String role ="SELLER";
    private String password;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String profileimage;
    private String locality;
    private String pincode;
    private String city;
    private String state;
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_additional_id")
    private UserAdditional userAdditional;



    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = "ADMIN";
        }
    }
    public User(UserDTO user){
        if(user.getId()!=null){
            this.id=user.getId();
        }
        this.name=user.getName();
        this.phone=user.getPhone();
        this.profileimage=user.getProfileimage();
        this.locality=user.getLocality();
        this.pincode=user.getPincode();
        this.city=user.getCity();
        this.state=user.getState();
        this.district=user.getDistrict();
        this.userAdditional=user.getUserAdditional();
        this.role=user.getRole();
    }

}
