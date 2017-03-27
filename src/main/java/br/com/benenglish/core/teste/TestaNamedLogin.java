package br.com.benenglish.core.teste;

import br.com.benenglish.core.modelo.Perfil;
import br.com.benenglish.core.modelo.Usuario;
import br.com.benenglish.core.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   22/03/2017
 */
public class TestaNamedLogin {

    public static void main(String[] args) {
        
        EntityManager manager = new JPAUtil().getEntityManager();
        
        Usuario usuario = new Usuario();
        usuario.setLogin("letribeiro");
        usuario.setSenha("123");
        
        TypedQuery<Usuario> query = manager.createNamedQuery("efetuarLogin", Usuario.class);
        query.setParameter("pLogin", usuario.getLogin());
        query.setParameter("pSenha", usuario.getSenha());
        
        Usuario user = query.getSingleResult();
        
        System.out.println("Becoins: " + user.getBecoins());
            StringBuilder sb = new StringBuilder();
            for (Perfil p : user.getPerfil()) {
                sb.append(p);
                sb.append(", ");
            }
            System.out.println("Perfis: "+sb);
        
    }

}
