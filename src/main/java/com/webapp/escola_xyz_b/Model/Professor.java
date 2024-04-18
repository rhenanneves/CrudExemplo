package com.webapp.escola_xyz_b.Model;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Professor implements Serializable{
    //Atributos
    @Id
    private String cpf;
    private String nome;
    private String disciplina;
    private String senha;
    //metodos
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
  
}
