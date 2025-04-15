package com.henriquefidelis.gerenciadordecursos.modules.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.gerenciadordecursos.modules.courses.dto.CourseDTO;
import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseDTO courseDTO, UUID id) {

        Optional<CourseEntity> courseExists = this.courseRepository.findById(id);
        if (!courseExists.isPresent()) {
            throw new RuntimeException("Curso não encontrado!");
        }

        CourseEntity course = courseExists.get();

        course.setName(courseDTO.getName());
        course.setCategory(courseDTO.getCategory());
        
        course = this.courseRepository.save(course);

        return course;
        
    }
    
}
