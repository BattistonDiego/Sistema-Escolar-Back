package com.escola.gestao_escolar.dto;

import com.escola.gestao_escolar.model.Professor;

public record ListaProfessores(
        Long id,
        String nome,
        String telefone,
        String email,
        String disciplina,
        Integer status

) {
    public ListaProfessores(Professor professor) {
        this( professor.getId(), professor.getNome(), professor.getTelefone(), professor.getEmail(), professor.getDisciplina(), professor.getStatus());
    }
}
