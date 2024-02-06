package com.eugooti.restapi.controller;


import com.eugooti.restapi.entity.ToDo;
import com.eugooti.restapi.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/createTodo")
    public ToDo createTodo(@RequestBody ToDo toDo){
        return toDoService.createToDo(toDo);
    }

    @PostMapping("/createToDos")
    public List<ToDo> createTodos(@RequestBody List<ToDo> toDos){
        return toDoService.createToDos(toDos);
    }

        @GetMapping("/allTodos")
    public List<ToDo> getAllTodos(){
        return toDoService.getToDos();
    }

    @GetMapping("/todo/{id}")
    public ToDo getTodoById(@PathVariable int id){
        return toDoService.getToDoById(id);
    }

    @GetMapping("/todos/{user}")
    public List<ToDo> getByUser(@PathVariable String user){
        return toDoService.getToDoByUser(user);
    }

    @PutMapping("/updateTodo")
    public ToDo updateTodo(@RequestBody ToDo toDo){
        return toDoService.updateToDo(toDo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable int id){
        return toDoService.deleteToDo(id);
    }

}
