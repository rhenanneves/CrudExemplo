package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.VerificaCadastroAdm;



public interface verificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String> {

VerificaCadastroAdm findByCpf(String cpf);


}
