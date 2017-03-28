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
        
        
        Usuario user = new Usuario();
        List<Perfil> perfis = new ArrayList<>();
        
        perfis.add(Perfil.TRADUTOR_NV_3);
        
        user.setPerfil(perfis);
        user.setBecoins(10000);
        user.setLogin("maria");
        user.setSenha("123");
        
        salvar(user);

        
    }
    
    public static void salvar(Object entity){
        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        
        manager.persist(entity);

        manager.getTransaction().commit();

        manager.close();
    }
    

}
