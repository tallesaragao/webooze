package webooze.controle;

import java.util.List;

import webooze.modelo.EntidadeDominio;

public interface IFachada {
	public String salvar(EntidadeDominio entidade);

	public String alterar(EntidadeDominio entidade);

	public String excluir(EntidadeDominio entidade);

	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
}
