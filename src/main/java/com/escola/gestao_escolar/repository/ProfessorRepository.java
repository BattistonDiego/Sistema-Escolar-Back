package com.escola.gestao_escolar.repository;

import com.escola.gestao_escolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {
}
