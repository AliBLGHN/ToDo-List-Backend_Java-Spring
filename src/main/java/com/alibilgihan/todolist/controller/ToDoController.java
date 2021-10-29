package com.alibilgihan.todolist.controller;
import com.alibilgihan.todolist.models.ToDo;
import com.alibilgihan.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todolist")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


                                    //Projeye göre kullanıcı giriş yaptığında sadece kendine ait todoları listeleyecek. Buna göre :
    @GetMapping("/{userid}")    // path'de girilen id numaralı user'a ait todoları listelemek için ilgili metoda gidilir.
    public List<ToDo> getAllToDoByUserid(@PathVariable int userid) {
        return toDoService.getAllToDoByUserid(userid);
    }


    @PostMapping()  // Requestbody'e girilen bilgiler ile, veritabanına yeni todo eklenmek üzere ilgili metoda gidilir.
    public ToDo createToDo(@RequestBody ToDo newToDo){
        return toDoService.createToDo(newToDo);
    }


    @PutMapping("/{todoid}")   // path'de girilen id'nin verileri requestbody'deki veriler ile güncellenmek üzere ilgili metoda gidilir.
    public ToDo updateToDo(@RequestBody ToDo newToDo,@PathVariable int todoid){
        return toDoService.updateToDo(newToDo,todoid);
    }


    @DeleteMapping("/{todoid}") // path'de girilen id'ye sahip olan todo tablodan silinmek üzere ilgili metoda gidilir.
    public void deleteToDo(@PathVariable int todoid){
        toDoService.deleteToDo(todoid);
    }
}
