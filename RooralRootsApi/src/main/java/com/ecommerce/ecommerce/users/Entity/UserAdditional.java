package com.ecommerce.ecommerce.users.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_additional")
public class UserAdditional {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private boolean customorder;
    private Long customizeOrderPrice;
  
}
