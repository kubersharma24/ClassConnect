package com.example.MasterRoom.Repositories;

import com.example.MasterRoom.Model.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
