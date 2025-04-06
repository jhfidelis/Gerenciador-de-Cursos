package com.henriquefidelis.gerenciadordecursos.modules.courses.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;

@RestController
@RequestMapping("/course")
public class CourseController {

    @PostMapping("/")
    public void create(@RequestBody CourseEntity courseEntity) {
        System.out.println("Curso");
        System.out.println(courseEntity.getName());
    }
    
}
