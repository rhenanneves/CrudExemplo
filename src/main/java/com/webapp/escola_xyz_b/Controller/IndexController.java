package com.webapp.escola_xyz_b.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acessoCadastroAdm() {
        return "cadastro/cadastro-adm";
    }

    @GetMapping("/login-prof")
    public String acessoLoginProf() {
        return "Professor/Login-prof";
    }

    @GetMapping("/cadastro-prof")
    public String acessoCadastroProf() {
        return "Professor/cadastro-prof";
    }

    @GetMapping("/interna-prof-adm")
    public String acessoInternaProfAdm() {
        return "interna/interna-prof-adm";
    }
    
    @GetMapping("/acesso-prof")
    public String acessoProf() {
        return "Professor/interna-prof";
    }
    @GetMapping("/login-aluno")
    public String loginAluno() {
        return "Aluno/login-aluno";
    }
    @GetMapping("/cadastro-aluno")
    public String cadastroAluno() {
        return "Aluno/cadastro-aluno";
    }
}
