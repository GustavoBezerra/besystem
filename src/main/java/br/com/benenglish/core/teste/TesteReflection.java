package br.com.benenglish.core.teste;

import br.com.benenglish.core.modelo.Usuario;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   28/03/2017
 */
public class TesteReflection {

    public static void main(String[] args) {
        Usuario user = new Usuario();
        testa(user);
    }
    
    public static void testa(Object entity){
        System.out.println(entity.getClass());
    }

}
