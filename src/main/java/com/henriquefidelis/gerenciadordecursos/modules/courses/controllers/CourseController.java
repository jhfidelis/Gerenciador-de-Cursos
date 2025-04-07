package com.henriquefidelis.gerenciadordecursos.modules.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquefidelis.gerenciadordecursos.exceptions.CourseFoundException;
import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/")
    public CourseEntity create(@Valid @RequestBody CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });

        return this.courseRepository.save(courseEntity);
    }

}
