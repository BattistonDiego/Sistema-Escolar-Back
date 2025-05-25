package com.escola.gestao_escolar.dto;

import com.escola.gestao_escolar.model.Professor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessores(
        @NotBlank
        String nome,

        @NotBlank
        String telefone,

        @NotBlank
        String email,

        @NotBlank
        String disciplina,

        @NotNull
        Integer status) {

    public DadosCadastroProfessores(Professor professor) {
        this(professor.getNome(), professor.getTelefone(), professor.getEmail(), professor.getDisciplina(), professor.getStatus());
    }

}