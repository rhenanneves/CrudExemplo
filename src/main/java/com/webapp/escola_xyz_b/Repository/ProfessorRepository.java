package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Professor;



public interface ProfessorRepository extends CrudRepository<Professor, String> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    VerificaCadastroProfRepository findByCpf(String cpf);
}
