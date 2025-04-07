package com.henriquefidelis.gerenciadordecursos.modules.courses.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquefidelis.gerenciadordecursos.modules.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    
}
