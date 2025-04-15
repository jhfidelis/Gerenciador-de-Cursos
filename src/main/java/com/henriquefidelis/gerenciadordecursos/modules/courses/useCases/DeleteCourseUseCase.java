package com.henriquefidelis.gerenciadordecursos.modules.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    CourseRepository courseRepository;

    public void execute (UUID id) {
        
        Optional<CourseEntity> courseExists = this.courseRepository.findById(id);
        if (!courseExists.isPresent()) {
            throw new RuntimeException("Curso não encontrado!");
        }

        CourseEntity course = courseExists.get();

        this.courseRepository.delete(course);
    }
    
}
