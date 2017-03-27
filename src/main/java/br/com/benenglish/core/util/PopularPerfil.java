package br.com.benenglish.core.util;

import br.com.benenglish.core.modelo.Perfil;
import br.com.benenglish.core.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 22/03/2017
 */
public class PopularPerfil {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        
        Usuario user = new Usuario();
        List<Perfil> perfis = new ArrayList<>();
        
        perfis.add(Perfil.ALUNO);
        
        user.setPerfil(perfis);
        user.setBecoins(50000);
        user.setLogin("gbezerra");
        user.setSenha("123");

        manager.getTransaction().begin();
        
        manager.persist(user);

        manager.getTransaction().commit();

        manager.close();
    }

}
