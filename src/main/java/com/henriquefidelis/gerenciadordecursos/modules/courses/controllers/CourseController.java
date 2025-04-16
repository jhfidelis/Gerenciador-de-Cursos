package com.henriquefidelis.gerenciadordecursos.modules.courses.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.henriquefidelis.gerenciadordecursos.modules.courses.dto.CourseDTO;
import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.CreateCourseUseCase;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.DeleteCourseUseCase;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.ListCoursesUseCase;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.UpdateCourseStatusUseCase;
import com.henriquefidelis.gerenciadordecursos.modules.courses.useCases.UpdateCourseUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCoursesUseCase listCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;
    
    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private UpdateCourseStatusUseCase updateCourseStatusUseCase;

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
    public List<CourseEntity> listCourses(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String category
    ) {
        return listCoursesUseCase.execute(name, category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody CourseDTO courseDTO, @PathVariable UUID id) {
        try {
            var result = this.updateCourseUseCase.execute(courseDTO, id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> updateStatus(@PathVariable UUID id) {
        try {
            var result = this.updateCourseStatusUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
