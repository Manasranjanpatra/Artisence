package com.ecommerce.ecommerce.users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.users.Entity.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
    public User findByPhone(String phone);

    public boolean existsByPhoneIgnoreCaseAndIdNot(String name, long l);

    public boolean existsByPhoneAndIdNot(String name, long l);
}
