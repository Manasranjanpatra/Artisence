package com.ecommerce.ecommerce.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Boolean status;
    private String message;
}
