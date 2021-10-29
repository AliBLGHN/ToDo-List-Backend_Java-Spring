package com.alibilgihan.todolist.repostories;
import com.alibilgihan.todolist.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IToDoRepository extends JpaRepository<ToDo, Integer>{
    List<ToDo> findAllByUserid(int userid);
}
