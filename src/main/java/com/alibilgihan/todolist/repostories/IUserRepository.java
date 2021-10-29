package com.alibilgihan.todolist.repostories;
import com.alibilgihan.todolist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
    User findByUsernameAndPassword(String username, String password);
    User findTopByUsername(String username);
}
