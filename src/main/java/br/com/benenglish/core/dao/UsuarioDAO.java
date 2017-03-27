package br.com.benenglish.core.dao;

import br.com.benenglish.core.modelo.EntidadeDominio;
import br.com.benenglish.core.modelo.Perfil;
import br.com.benenglish.core.modelo.Usuario;
import br.com.benenglish.core.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 25/03/2017
 */
public class UsuarioDAO implements IDAO {

    @Override
    public void salvar(EntidadeDominio entidade) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Usuario user = (Usuario) entidade;

        manager.getTransaction().begin();

        manager.persist(user);

        manager.getTransaction().commit();

        manager.close();
    }

    @Override
    public void alterar(EntidadeDominio entidade) {
        salvar(entidade);
    }

    @Override
    public void excluir(EntidadeDominio entidade) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Usuario user = (Usuario) entidade;

        manager.getTransaction().begin();

        manager.remove(user);

        manager.getTransaction().commit();

        manager.close();
    }

    @Override
    public List<Usuario> consultar(EntidadeDominio entidade) {
        EntityManager manager = new JPAUtil().getEntityManager();
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);

        return query.getResultList();
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) {

        Usuario usuario = (Usuario) entidade;
        Usuario user = null;
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

            user = typedQuery.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum registro encontrado!");
        } finally {
            manager.close();
        }
        return user;
    }

}
