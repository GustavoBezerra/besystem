package br.com.benenglish.core.controller;

import br.com.benenglish.core.dao.UsuarioDAO;
import br.com.benenglish.core.modelo.Perfil;
import br.com.benenglish.core.modelo.Usuario;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 24/03/2017
 */
@Controller
public class UsuarioController {
    
    UsuarioDAO dao = new UsuarioDAO();
    
    @RequestMapping("/")
    public String index(){
        return "home/starter";
    }
    

    @RequestMapping("/usuario/login")
    public String login(Usuario user) {        
        Usuario usuario = (Usuario) dao.visualizar(user);
        StringBuilder sb = new StringBuilder();
        if (usuario == null) {
            System.out.println("Nenhum usuario encontrado! (Controller)");
        } else {
            for (Perfil p : usuario.getPerfil()) {
                sb.append(p);
                sb.append(", ");
            }
            System.out.println("Usuario: " + usuario.getLogin());
            System.out.println("Perfis: " + sb);
        }
        return "home/index";
    }
    
    @RequestMapping(value="/usuario/todos", method = RequestMethod.GET)
    public @ResponseBody List<Usuario> getShopInJSON() {
        List<Usuario> usuarios = dao.consultar(new Usuario());
        return usuarios;     
    }

}
