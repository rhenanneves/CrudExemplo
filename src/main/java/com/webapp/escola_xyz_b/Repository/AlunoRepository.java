package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.AlunoModel;

public interface AlunoRepository extends CrudRepository<AlunoModel, String> {
    // se eu precisar criar algum método extra, eu vou criar aqui
    AlunoModel findByRegistroAluno(String RegistroAluno);

}
