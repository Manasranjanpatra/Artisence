package com.ecommerce.ecommerce.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    
    private String phone;
    private String password;
}
