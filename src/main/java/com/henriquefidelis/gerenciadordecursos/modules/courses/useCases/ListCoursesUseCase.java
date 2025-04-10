package com.henriquefidelis.gerenciadordecursos.modules.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;
import com.henriquefidelis.gerenciadordecursos.modules.courses.repositories.CourseRepository;

@Service
public class ListCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }
    
}
