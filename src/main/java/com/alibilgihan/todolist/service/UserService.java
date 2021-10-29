package com.alibilgihan.todolist.service;
import com.alibilgihan.todolist.models.User;
import com.alibilgihan.todolist.repostories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository; //veritabanındak sorgulama işlemlerini JPA sayesinde otomatik olarak yapıyoruz



    public User createUser(User user) { // Controller'dan gelen user objesinin username'i veritabanında zaten var ise eklenmemesi için kontrol yapılır.
        boolean existuser;
        existuser = userRepository.findTopByUsername(user.getUsername()) != null ? true : false;

        if(existuser)   // Veritabanında eklenmek istenen username zaten var ise eklenemez.
            return null;
        else if (user.getCpassword().equals(user.getPassword()))   // veritabanında eklenmekistenen username yok ise ve girilen şifreler eşit ise veritabanına kaydedilir.
            return userRepository.save(user);
        else    // Şifreler eşleşmiyorsa eklenemez.
            return null;
    }



    public User loginUser(User user) {  // Controllerden gelen User obejesi giriş yapmak istiyor bu yüzden gelen username ve password'a sahip User veritabanında aranır bulunursa id numarası döndürülür..
        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }



    public List<User> getAllUser() {    // Tüm user bilgileri döndürülür.
        return this.userRepository.findAll();
    }
}
