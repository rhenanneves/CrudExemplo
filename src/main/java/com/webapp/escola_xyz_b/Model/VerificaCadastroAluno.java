package com.webapp.escola_xyz_b.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VerificaCadastroAluno {
      @Id
    private String nome;
    private String registroAluno;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroAluno() {
        return registroAluno;
    }

    public void setRegistroAluno(String registroAluno) {
        this.registroAluno = registroAluno;
    }
}
