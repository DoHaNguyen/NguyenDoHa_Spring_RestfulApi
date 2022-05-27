package com.example.nguyendoha_spring_restfulapi.Repository;

import com.example.nguyendoha_spring_restfulapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// Nguyen Do ha 28/5/2022
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String Email);
}
