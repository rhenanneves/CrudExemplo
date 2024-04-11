package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Model.VerificaCadastroAdm;

@Repository
public interface VerificaCadastroProfRepository extends CrudRepository<Professor, String> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    VerificaCadastroAdm findByCpf(String cpf);
}
