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

    public List<CourseEntity> execute(String name, String category) {
        if (name != null && category != null) {
            return this.courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }

        if (name != null) {
            return this.courseRepository.findByNameContainingIgnoreCase(name);
        }

        if (category != null) {
            return this.courseRepository.findByCategoryContainingIgnoreCase(category);
        }

        return this.courseRepository.findAll();
    }
    
}
