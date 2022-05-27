package com.example.nguyendoha_spring_restfulapi.Service;

import com.example.nguyendoha_spring_restfulapi.Model.User;
import com.example.nguyendoha_spring_restfulapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Nguyen Do ha 28/5/2022
@Service
public class UserServiceimp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> showUser() {
        return (List<User>) userRepository.findAll();
    }

    public void adduser(User user) {
        userRepository.save(user);
    }

    public User data(User user) {
        return userRepository.findByEmail(user.getEmail());
    }

    public Object findbyid(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id) {
        User user = userRepository.getReferenceById(id);
        return user;
    }

    public void deleteUser(Long id) {
        User user = userRepository.getReferenceById(id);
        userRepository.delete(user);
    }
}
