package com.sp.jobportal.client.services.controller;

import com.sp.jobportal.client.services.RestClientTodoService;
import com.sp.jobportal.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodosController {

    private final RestClientTodoService restClientTodoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(restClientTodoService.findAll());
    }

    //write code for find by id
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable long id) {
        return ResponseEntity.ok(restClientTodoService.findById(id));
    }

    //write code for createdto
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restClientTodoService.create(todoDto));
    }

    //write code for update todoDto
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(restClientTodoService.update(id, todoDto));
    }

    //write code for delete one tododto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id) {
        restClientTodoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully.....");
    }
}
