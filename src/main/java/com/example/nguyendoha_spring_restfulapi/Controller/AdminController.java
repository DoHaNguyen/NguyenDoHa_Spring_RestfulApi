package com.example.nguyendoha_spring_restfulapi.Controller;

import com.example.nguyendoha_spring_restfulapi.Model.User;
import com.example.nguyendoha_spring_restfulapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
// Nguyen Do ha 28/5/2022
@RestController
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/dangki")
    public String CreateUser(@RequestBody User user) {
        try {
            userService.adduser(user);
            return "Đăng kí thành công !";
        } catch (Exception e) {
            return "Lỗi đăng kí";
        }
    }

    @GetMapping("/user")
    public Object user(HttpSession session) {
        if (session.getAttribute("check") != null) {
            return userService.showUser();
        } else {
            return "Bạn không có quyền xem thông tin";
        }
    }

    @GetMapping("user/{id}")
    public Object userid(@PathVariable(value = "id") Long id, HttpSession session) {
        if (session.getAttribute("check") != null) {
            if (userService.findbyid(id).toString() != "Optional.empty") {
                return userService.findbyid(id);
            } else {
                return "Id không tồn tại";
            }
        } else {
            return "Bạn không có quyền xem thông tin";
        }
    }

    @PostMapping("/dangnhap")
    public String dangnhap(@RequestBody User user, HttpSession session) {
        User Data = userService.data(user);
        if (Data == null) {
            return "Email của bạn không tồn tại";
        } else {
            if (Data.getEmail().equals(user.getEmail())) {
                if (Data.getPassword().equals(user.getPassword())) {
                    session.setAttribute("check", true);
                    return "Đăng nhập thành công";
                } else {
                    return "mật khẩu bị sai";
                }
            }
        }
        return null;
    }

    @GetMapping("/dangxuat")
    public String dangxuat(HttpSession session) {
        session.removeAttribute("check");
        return "Đã Đăng xuất";
    }

    @PutMapping("/user/update/{id}")
    public String update(@PathVariable(name = "id") Long id, @RequestBody User user, HttpSession session) {
        if (session.getAttribute("check") != null) {
            User user1 = userService.updateUser(id);
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            userService.adduser(user1);
            return "Đã update user thành công";
        } else {
            return "Bạn không có quyền sửa thông tin";
        }
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id, HttpSession session) {
        if (session.getAttribute("check") != null) {
            userService.deleteUser(id);
            return "Đã xóa user thành công";
        } else {
            return "Bạn không có quyền thực hiện thao tác này";
        }
    }
}
