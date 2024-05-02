package com.webapp.escola_xyz_b.Model;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Notas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNota;
    public long getIdNota() {
        return idNota;
    }
    public void setIdNota(long idNota) {
        this.idNota = idNota;
    }
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "disciplina")
    private Professor disciplina;
    @ManyToOne
    @JoinColumn(name = "nome", referencedColumnName = "nome")
    private AlunoModel nome;
    private double nota;
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Professor getMateria() {
        return disciplina;
    }
    public void setMateria(Professor disciplina) {
        this.disciplina = disciplina;
    }
    public AlunoModel getNome() {
        return nome;
    }
    public void setNomeAluno(AlunoModel nome) {
        this.nome = nome;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    
}

