package com.escola.gestao_escolar.model;

import com.escola.gestao_escolar.dto.AtualizaProfessor;
import com.escola.gestao_escolar.dto.DadosCadastroProfessores;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity // Diz que essa classe é uma entidade (tabela)
@Table(name = "professores") // Nome da tabela no banco
@Data // Lombok: cria getters, setters, equals, hashCode e toString
@NoArgsConstructor // Lombok: construtor vazio
@AllArgsConstructor // Lombok: construtor com todos os campos
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String disciplina;
    private Integer status;

    public Professor(DadosCadastroProfessores dadosCadastroProfessores) {
        this.nome = dadosCadastroProfessores.nome();
        this.telefone = dadosCadastroProfessores.telefone();
        this.email = dadosCadastroProfessores.email();
        this.disciplina = dadosCadastroProfessores.disciplina();
        this.status = dadosCadastroProfessores.status();
    }

    public void atualizarDados(AtualizaProfessor dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.disciplina() != null) {
            this.disciplina = dados.disciplina();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }

    public void excluir(){
        this.status = 0;
    }
}
