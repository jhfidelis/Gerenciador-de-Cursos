package com.henriquefidelis.gerenciadordecursos.modules.courses.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseEntity {

    private UUID id;

    @NotBlank(message = "O nome do curso é um campo obrigatório")
    private String name;

    @NotBlank(message = "A categoria do curso é um campo obrigatório")
    private String category;

    private Boolean Active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
