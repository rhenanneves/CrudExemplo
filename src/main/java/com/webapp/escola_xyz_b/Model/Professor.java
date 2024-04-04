package com.webapp.escola_xyz_b.Model;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Professor {
    //Atributos
    @Id
    private String cpf;
    private String nome;
    private String disciplina;
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
    
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
