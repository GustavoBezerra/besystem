package br.com.benenglish.core.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   22/03/2017
 */
public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("benenglish-postgres");
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
