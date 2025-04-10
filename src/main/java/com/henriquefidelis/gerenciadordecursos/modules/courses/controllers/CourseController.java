package com.henriquefidelis.gerenciadordecursos.modules.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.CreateCourseUseCase;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.ListCoursesUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCoursesUseCase listAllCoursesUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<CourseEntity> listAllCourses() {
        return listAllCoursesUseCase.execute();
    }

}
