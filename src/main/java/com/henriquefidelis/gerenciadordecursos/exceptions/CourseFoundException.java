package com.henriquefidelis.gerenciadordecursos.exceptions;

public class CourseFoundException extends RuntimeException {
    
    public CourseFoundException() {
        super("Esse curso já existe no nosso catálogo!");
    }
}
