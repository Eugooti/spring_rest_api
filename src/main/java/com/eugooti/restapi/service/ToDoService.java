package com.eugooti.restapi.service;

import com.eugooti.restapi.entity.ToDo;
import com.eugooti.restapi.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo){
        return toDoRepository.save(toDo);
    }
    public List<ToDo> createToDos(List<ToDo> toDo){
        return toDo;
    }
    public List<ToDo> getToDos(){
        return toDoRepository.findAll();
    }
    public ToDo getToDoById(int id){
        return toDoRepository.findById(id).orElse(null);
    }
    public List<ToDo> getToDoByUser(String user){
        return toDoRepository.findByCreatedBy(user);
    }
    public ToDo updateToDo(ToDo toDo){

        ToDo toDo1=toDoRepository.findById(toDo.getId()).orElse(null);
        assert toDo1 !=null;

        toDo1.setTitle(toDo.getTitle());
        toDo1.setDescription(toDo.getDescription());
        toDo1.setDate(toDo.getDate());

        return toDoRepository.save(toDo1);
    }
    public String deleteToDo(int id){
        toDoRepository.deleteById(id);

        return "Deleted Successfully";
    }

}
