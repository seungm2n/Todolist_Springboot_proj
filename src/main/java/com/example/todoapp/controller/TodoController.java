package com.example.todoapp.controller;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model m) {
        // Todo 리스트 불러오기
        List<Todo> todos = todoRepository.findAll();
        m.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo) {
//      System.out.println(todo);   // 입력 받은 값 Console 출력

        //database에 저장
        Todo toDo = new Todo();
        toDo.setTodo(todo);
        todoRepository.save(toDo);
        return "redirect:/";
    }

}
