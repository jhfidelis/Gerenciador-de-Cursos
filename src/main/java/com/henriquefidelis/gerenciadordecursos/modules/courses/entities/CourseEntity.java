package com.henriquefidelis.gerenciadordecursos.modules.courses.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CourseEntity {

    private UUID id;
    private String name;
    private String category;
    private Boolean Active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
