package com.escola.gestao_escolar.controller;

import com.escola.gestao_escolar.dto.AtualizaProfessor;
import com.escola.gestao_escolar.dto.DadosCadastroProfessores;
import com.escola.gestao_escolar.dto.ListaProfessores;
import com.escola.gestao_escolar.model.Professor;
import com.escola.gestao_escolar.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
@CrossOrigin(origins = "http://localhost:4200") // Libera só para o Angular
public class GestaoEscolarController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional // Garante que o métodod execute dentro de uma transação
    public void cadastrarProfessores(@RequestBody @Valid DadosCadastroProfessores cadastroProfessores){
        var professor = new Professor(cadastroProfessores);
        repository.save(professor);
    }

    @GetMapping
    public List<ListaProfessores> listarProfessores(){
        return repository.findAll().stream().map(ListaProfessores::new).toList();
    }

    @GetMapping("/{id}")
    ResponseEntity<Professor> getProfessorById(@PathVariable long id){
        Optional<Professor> prof = repository.findById(id);

        if(prof.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prof.get());
    }

    @PutMapping("/{id}") //Define que essa rota é chamada com mé/odo PUT, e espera um id na URL. Ex: /professores/3
    @Transactional
    public ResponseEntity<Void> atualizarProfessores(@PathVariable Long id, @RequestBody @Valid AtualizaProfessor dados) {
        Optional<Professor> optionalProfessor = repository.findById(id); //Busca no banco o professor com aquele ID.

        if (optionalProfessor.isEmpty()) { //isEmpty = esta vazia
            return ResponseEntity.notFound().build();
        }
        Professor professor = optionalProfessor.get();
        professor.atualizarDados(dados);

        return ResponseEntity.noContent().build(); //Retorna 204 indicando sucesso sem conteúdo (padrão para PUT).

    }

    @DeleteMapping("/{id}") //Define que essa rota é chamada com mé/odo DELETE, e espera um id na URL. Ex: /professores/3
    @Transactional
    public ResponseEntity<Void> deletarProfessores(@PathVariable Long id) {
        var professor = repository.getReferenceById(id); //Busca no banco o professor com aquele ID
        professor.excluir();

        return ResponseEntity.noContent().build(); //Retorna 204 indicando sucesso sem conteúdo (padrão para PUT).
    }

}
