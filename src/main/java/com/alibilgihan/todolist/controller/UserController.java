package com.alibilgihan.todolist.controller;
import com.alibilgihan.todolist.models.User;
import com.alibilgihan.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")    //Requestbody'e girilen bilgiler ile yeni kullanıcı kaydı yapılmak üzere ilgili metoda gidiliyor.
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }


    @PostMapping("/login")  // Giriş sayfasında girilen bilgilerin veritabanında olup olmadığı kontrol edilecek. Var ise id numarası geri döndürülecek.
    public User loginUser(@RequestBody User loginUser){
        return userService.loginUser(loginUser);
    }


    @GetMapping()   // (Opsiyonel) tüm kullanıcılar görülmek üstenirse bu metod kullanılabilir. (proje konusu bu metodu gerektirmiyor.)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
