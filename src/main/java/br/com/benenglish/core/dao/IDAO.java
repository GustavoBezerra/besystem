package br.com.benenglish.core.dao;

import br.com.benenglish.core.modelo.EntidadeDominio;
import br.com.benenglish.core.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date   25/03/2017
 */
public interface IDAO {
    
    public void salvar(EntidadeDominio entidade);
    public void alterar(EntidadeDominio entidade);
    public void excluir(EntidadeDominio entidade);
    public List<Usuario> consultar(EntidadeDominio entidade);
    public EntidadeDominio visualizar(EntidadeDominio entidade);

}
