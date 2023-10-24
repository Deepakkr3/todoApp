package com.todo.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    List<Todo> todoList;
    //create todo post api
    @PostMapping("todo")
    public String addTodo( @RequestBody Todo mytodo)
    {  todoList.add(mytodo);
        return "todu added";

    }
    //get all todo getapi
    @GetMapping("todos")
    public List<Todo> getAllTodo()
    {
        return  todoList;
    }
    //update put
    // send todo id :d1 and status:s1
    @PutMapping("update/id/{id}/status/{flag}")
    public String setTodoStatusById(@PathVariable Integer id, @PathVariable boolean flag)
    {
        for(Todo todo:todoList)
        { if(todo.getTodoId().equals(id))
        {
            todo.setTodoStatus(flag);
            return  "todo status updated with "+" "+id+" :"+flag  ;
        }

        }
        return "invalid id";
    }
    //delete
    @DeleteMapping("todo/delete/id/{}")
    public String del(@PathVariable Integer id)
    {
        for(Todo todo:todoList)
        { if(todo.getTodoId().equals(id))
        {
            todoList.remove(todo);
            return  "todo with id +"+" "+id+"has been deleted "  ;
        }

        }
        return "invalid id";
    }





}
