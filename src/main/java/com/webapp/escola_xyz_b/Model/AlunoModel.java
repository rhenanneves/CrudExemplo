package com.webapp.escola_xyz_b.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class AlunoModel implements Serializable {

    @Id
    private String nome;
    private String registroAluno;
    private String senha;
    private String materia;

 

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

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
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}