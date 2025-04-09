package com.henriquefidelis.gerenciadordecursos.modules.courses.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.henriquefidelis.gerenciadordecursos.enuns.IsActiveEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "tb_course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome do curso é um campo obrigatório")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "A categoria do curso é um campo obrigatório")
    @Column(nullable = false, length = 50)
    private String category;

    @NotNull
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private IsActiveEnum isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
}
