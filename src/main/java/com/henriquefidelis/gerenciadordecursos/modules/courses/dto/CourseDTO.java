package com.henriquefidelis.gerenciadordecursos.modules.courses.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.henriquefidelis.gerenciadordecursos.enuns.IsActiveEnum;

import lombok.Data;

@Data
public class CourseDTO {

    private UUID id;
    private String name;
    private String category;
    private IsActiveEnum isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
