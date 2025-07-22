package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
    
}
