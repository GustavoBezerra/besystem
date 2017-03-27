package br.com.benenglish.core.modelo;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   22/03/2017
 */

@NamedQuery(name = "efetuarLogin",
            query = "select u from Usuario u where u.login=:pLogin  and u.senha = :pSenha")

@Entity
public class Usuario extends EntidadeDominio{
    
    @Id @GeneratedValue
    private int id;
    
    @ElementCollection(targetClass = Perfil.class)
    @Enumerated(EnumType.STRING)
    private List<Perfil> perfil;
    private long becoins;
    private String login;
    private String senha;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the perfil
     */
    public List<Perfil> getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(List<Perfil> perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the becoins
     */
    public long getBecoins() {
        return becoins;
    }

    /**
     * @param becoins the becoins to set
     */
    public void setBecoins(long becoins) {
        this.becoins = becoins;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
