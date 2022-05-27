package com.example.nguyendoha_spring_restfulapi.Service;

import com.example.nguyendoha_spring_restfulapi.Model.User;

import java.util.List;
import java.util.Optional;
// Nguyen Do ha 28/5/2022
public interface UserService {
    public List<User> showUser();
    public void adduser(User user);
    public User data(User user);
    public Object findbyid(Long id);
    public User updateUser(Long id);
    public void deleteUser(Long id);
}
