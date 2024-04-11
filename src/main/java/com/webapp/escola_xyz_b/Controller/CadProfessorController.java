package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Repository.ProfessorRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroProfRepository;

@Controller
public class CadProfessorController {

    @Autowired
    ProfessorRepository pr;
    @Autowired
    VerificaCadastroProfRepository vcpr;

    boolean acessoProf = false;

    @PostMapping("cadastrar-prof")
    public String cadastrarProfessor(@RequestParam String cpf,
            @RequestParam String nome,
            @RequestParam String disciplina,
            @RequestParam String senha) {
        boolean verificaCpf = vcpr.existsById(cpf);
        if (verificaCpf) {
            Professor professor = new Professor();
            professor.setCpf(cpf);
            professor.setNome(nome);
            professor.setDisciplina(disciplina);
            professor.setSenha(senha);
            pr.save(professor);
            System.out.println("Cadastro do professor realizado com sucesso ");
        } else {
            System.out.println("Falha ao cadastrar professor");
        }
        return "/interna/interna-adm";
    }

    // Implemente os métodos de acesso ao painel interno do professor, se necessário

}
