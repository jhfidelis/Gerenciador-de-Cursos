package com.henriquefidelis.gerenciadordecursos.modules.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.gerenciadordecursos.enuns.IsActiveEnum;
import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

@Service
public class UpdateCourseStatusUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id) {

        Optional<CourseEntity> courseExists = this.courseRepository.findById(id);
        if (!courseExists.isPresent()) {
            throw new RuntimeException("Curso não encontrado!");
        }

        CourseEntity course = courseExists.get();

        if (course.getIsActive() == IsActiveEnum.ACTIVE) {
            course.setIsActive(IsActiveEnum.INACTIVE);
        } else {
            course.setIsActive(IsActiveEnum.ACTIVE);
        }

        return courseRepository.save(course);

    }
    
}
