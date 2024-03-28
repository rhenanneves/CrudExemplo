package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webapp.escola_xyz_b.Model.Administrador;
import com.webapp.escola_xyz_b.Repository.AdministradorRepository;
import com.webapp.escola_xyz_b.Repository.verificaCadastroAdmRepository;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorRepository ar;
    @Autowired
    verificaCadastroAdmRepository vcar;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administrador adm) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            ar.save(adm);
            System.out.println("Cadastro realizado com sucesso ");
        } else {
            System.out.println("Falha ao Cadastrar");
        }
        return "/login/login-adm";
    }

}
