package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

import com.webapp.escola_xyz_b.Model.AlunoModel;
import com.webapp.escola_xyz_b.Repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository ar;

    boolean acessoAluno = false;

    @PostMapping("/cadastro-aluno")
    public String postCadastroAluno(AlunoModel aluno, Model model) {
        // Verifica se algum campo obrigatório está vazio
        if (aluno.getNome() == null || aluno.getNome().isEmpty() ||
                aluno.getMateria() == null || aluno.getMateria().isEmpty() ||
                aluno.getRegistroAluno() == null || aluno.getRegistroAluno().isEmpty() ||
                aluno.getSenha() == null || aluno.getSenha().isEmpty()) {
            model.addAttribute("mensagem", "Por favor, preencha todos os campos.");
            return "interna/interna-adm";
        }

        // Salva o aluno se todos os campos estiverem preenchidos
        ar.save(aluno);
        model.addAttribute("mensagem", "Cadastro de aluno realizado com sucesso!");
        return "interna/interna-adm";
    }

    @PostMapping("acesso-aluno")
    public ModelAndView AcessoPageAdm(@RequestParam String registroAluno, @RequestParam String senha,
            RedirectAttributes attributes) {

        // Verifica se o CPF fornecido existe no banco de dados
        AlunoModel aluno = ar.findByRegistroAluno(registroAluno);
        if (aluno == null) {

            ModelAndView errorMv = new ModelAndView();
            errorMv.setViewName("redirect:/login-aluno");
            return errorMv;
        }

        // O CPF existe, continua com a verificação da senha
        boolean acessoSenha = senha.equals(aluno.getSenha());
        ModelAndView mv = new ModelAndView();

        if (acessoSenha) {
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoAluno = true;

            mv.setViewName("Aluno/interna-aluno");
        } else {
            String mensagem = "Senha Incorreta";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login-aluno");
        }

        return mv;
    }
    @GetMapping("/gerenciamento-aluno")
    public String listarAlunos(Model model) {
        Iterable<AlunoModel> alunos = ar.findAll();
        model.addAttribute("alunos", alunos);
        return "Aluno/gerenciamento-aluno";
    }
}