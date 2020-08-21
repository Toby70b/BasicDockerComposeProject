package com.example.todoapp.controller;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoItemController {


    private final TodoItemService todoItemService;

    @CrossOrigin
    @GetMapping(value = "/")
    public ResponseEntity<List<TodoItem>> getTodoItems() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(todoItemService.getTodoItems());
    }

    @CrossOrigin
    @PostMapping(value = "/")
    public ResponseEntity<String> createTodoItem(@RequestBody TodoItem newTodoItem) {
        todoItemService.createNewTodoItem(newTodoItem);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Todo item added successfully");
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTodoItem(@PathVariable(name = "id") String todoItemId) {
        ResponseEntity<String> response;

        try {
            todoItemService.deleteTodoItem(todoItemId);
            response = ResponseEntity.status(HttpStatus.OK)
                    .body("Todo item deleted successfully");
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

        return response;
    }


    @CrossOrigin
    @PutMapping(value = "/")
    public ResponseEntity<String> updateTodoItem(@RequestBody TodoItem newTodoItem) throws Exception {
        todoItemService.updateTodoItem(newTodoItem);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Todo item updated successfully");
    }
}
