package com.henriquefidelis.gerenciadordecursos.enuns;

public enum IsActiveEnum {
    
    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    private final String status;

    IsActiveEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
