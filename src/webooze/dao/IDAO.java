package webooze.dao;

import java.util.List;

import webooze.modelo.EntidadeDominio;

public interface IDAO {
	boolean salvar(EntidadeDominio entidade);
	boolean alterar(EntidadeDominio entidade);
	List<EntidadeDominio> consultar(EntidadeDominio entidade);
	boolean excluir(EntidadeDominio entidade);
}
