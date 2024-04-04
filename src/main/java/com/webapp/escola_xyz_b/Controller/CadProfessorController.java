package com.webapp.escola_xyz_b.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CadProfessorController {

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        // Simulando uma lista de disciplinas
        List<String> listaDeDisciplinas = new ArrayList<>();
        listaDeDisciplinas.add("Matemática");
        listaDeDisciplinas.add("História");
        listaDeDisciplinas.add("Geografia");
        listaDeDisciplinas.add("Português");
        listaDeDisciplinas.add("Ingles");

        model.addAttribute("listaDeDisciplinas", listaDeDisciplinas);

        return "cadastro"; // Retorna o nome do arquivo HTML/Thymeleaf sem extensão
    }
}
