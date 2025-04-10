package com.henriquefidelis.gerenciadordecursos.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.gerenciadordecursos.exceptions.CourseFoundException;
import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                .ifPresent((course) -> {
                    throw new CourseFoundException();
                });

        return this.courseRepository.save(courseEntity);
    }
    
}
