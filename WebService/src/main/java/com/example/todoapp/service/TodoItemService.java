package com.example.todoapp.service;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public void createNewTodoItem(TodoItem newTodoItem){
        todoItemRepository.save(newTodoItem);
    }

    public void updateTodoItem(TodoItem newTodoItem) throws Exception {
        Optional<TodoItem> todoItem = todoItemRepository.findById(newTodoItem.getId());
        if(todoItem.isPresent()){
            todoItem.get().setCompleted(newTodoItem.isCompleted());
            todoItemRepository.save(todoItem.get());
        }
        // In real case this should be a specific TodoItemNotFoundException
        else {
            throw new Exception("Todo item not found");
        }
    }

    public void deleteTodoItem(String todoItemId) throws Exception {
        Optional<TodoItem> todoItem = todoItemRepository.findById(todoItemId);
        if(todoItem.isPresent()){
            todoItemRepository.deleteById(todoItemId);
        }
        // In real case this should be a specific TodoItemNotFoundException
        else {
            throw new Exception("Todo item not found");
        }
    }

    public List<TodoItem> getTodoItems() {
        return todoItemRepository.findAll();
    }
}
