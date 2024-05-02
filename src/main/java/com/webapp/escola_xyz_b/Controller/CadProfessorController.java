package com.webapp.escola_xyz_b.Controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.webapp.escola_xyz_b.Model.Professor;
import com.webapp.escola_xyz_b.Repository.AlunoRepository;
import com.webapp.escola_xyz_b.Repository.ProfessorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CadProfessorController {

    @Autowired
    ProfessorRepository pr;
    AlunoRepository ar;

    @PostMapping("/cadastrar-prof")
    public String postCadastroDocente(Professor professor, Model model) {
        // Verifica se algum campo obrigatório está vazio
        if (professor.getNome() == null || professor.getNome().isEmpty() ||
            professor.getDisciplina() == null || professor.getDisciplina().isEmpty() ||
            professor.getCpf() == null || professor.getCpf().isEmpty() ||
            professor.getSenha() == null || professor.getSenha().isEmpty()) {
            model.addAttribute("mensagem", "Por favor, preencha todos os campos.");
            return "interna/interna-adm";
        }

        // Salva o professor se todos os campos estiverem preenchidos
        pr.save(professor);
        model.addAttribute("mensagem", "Cadastro de docente realizado com sucesso!");
        return "interna/interna-adm";
    }

    @PostMapping("/acesso-prof")
    public ModelAndView acessoProfessor(@RequestParam String cpf, @RequestParam String senha) {
        ModelAndView mv = new ModelAndView();
        
        // Verifica se o CPF fornecido existe no banco de dados
        Optional<Professor> optionalProfessor = pr.findById(cpf);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            
            // O CPF existe, continua com a verificação da senha
            if (senha.equals(professor.getSenha())) {
                String mensagem = "Login realizado com sucesso";
                System.out.println(mensagem);
                mv.setViewName("Professor/acessoprof");
            } else {
                String mensagem = "Senha incorreta";
                System.out.println(mensagem);
                mv.setViewName("redirect:/Professor/Login-prof");
            }
        } else {
            String mensagem = "CPF não encontrado";
            System.out.println(mensagem);
            mv.setViewName("redirect:/Professor/Login-prof");
        }

        return mv;
    }

    @GetMapping("/gerenciamento-docente")
    public String listarDocentes(Model model) {
        List<com.webapp.escola_xyz_b.Model.Professor> professores = (List<Professor>) pr.findAll(); // Importe explicitamente a classe Professor se necessário
        model.addAttribute("Professores", professores);
        return "Professor/gerenciamento-prof"; 
    }

    @GetMapping("/filtro-alunos")
    public ModelAndView lancarNotas(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("Aluno/filtrar-alunos");
        Professor professor = (Professor) session.getAttribute("Professor");
        if (professor != null) {
            modelAndView.addObject("docente", professor);
            modelAndView.addObject("alunos", ar.findAll());
        } else {
            // Adicionando uma mensagem de depuração
            System.out.println("A sessão do professor não foi encontrada ou expirou.");
            modelAndView.setViewName("Professor/Login-prof");
        }
        return modelAndView;
    }
    
}
