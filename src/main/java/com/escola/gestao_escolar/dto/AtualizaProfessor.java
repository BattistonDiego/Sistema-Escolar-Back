package com.escola.gestao_escolar.dto;

public record AtualizaProfessor(
        String nome,
        String telefone,
        String email,
        String disciplina,
        Integer status) {
}
