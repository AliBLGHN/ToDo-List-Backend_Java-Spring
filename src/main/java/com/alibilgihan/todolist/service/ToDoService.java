package com.alibilgihan.todolist.service;
import com.alibilgihan.todolist.exception.ResourcesNotFoundException;
import com.alibilgihan.todolist.models.ToDo;
import com.alibilgihan.todolist.repostories.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private IToDoRepository toDoRepository;


    public ToDo createToDo(ToDo todo) {     // Database'deki todo ların bulunduğu tabloya, gelen todo objesini ekler
        return toDoRepository.save(todo);
    }


    public ToDo updateToDo(ToDo toDo, int id) {
        Optional<ToDo> existToDo = this.toDoRepository.findById(id);
        if (existToDo.isPresent()){
            ToDo utodo = existToDo.get();
            utodo.setText(toDo.getText());
            utodo.setUserid(toDo.getUserid());
            utodo.setStatus(toDo.isStatus());
            toDoRepository.save(utodo);
            return utodo;
        }else {
            throw new ResourcesNotFoundException(toDo.getTid() + " Id numarasına ait veri bulunamadı");
        }
    }



    public List<ToDo> getAllToDoByUserid(int userid) {

        return this.toDoRepository.findAllByUserid(userid);
    }



    public void deleteToDo(int id) {
        Optional<ToDo> todo = this.toDoRepository.findById(id);
        if (todo.isPresent()){
            this.toDoRepository.deleteById(id);
        }else {
            throw new ResourcesNotFoundException(id + " Id numarasına ait veri bulunamadı");
        }
    }


}
