package br.com.benenglish.core.teste;

import br.com.benenglish.core.modelo.Perfil;
import br.com.benenglish.core.modelo.Usuario;
import br.com.benenglish.core.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 22/03/2017
 */
public class TestaLogin {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        usuario.setLogin("letribeiro");
        usuario.setSenha("123");

        EntityManager manager = new JPAUtil().getEntityManager();

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        // Qual o retorno que queremos
        CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
        // Em qual classe iremos nos basear
        Root<Usuario> from = criteria.from(Usuario.class);

        try {
            TypedQuery<Usuario> typedQuery = manager.createQuery(
                    criteria.select(from).where(
                            builder.equal(from.get("login"), usuario.getLogin()),
                            builder.equal(from.get("senha"), usuario.getSenha())
                    ));

            Usuario user = typedQuery.getSingleResult();

            System.out.println("Becoins: " + user.getBecoins());
            StringBuilder sb = new StringBuilder();
            for (Perfil p : user.getPerfil()) {
                sb.append(p);
                sb.append(", ");
            }
            System.out.println("Perfis: "+sb);
        } catch (NoResultException e) {
            System.out.println("Nenhum registro encontrado!");
        } finally{
            manager.close();
        }

    }

}
