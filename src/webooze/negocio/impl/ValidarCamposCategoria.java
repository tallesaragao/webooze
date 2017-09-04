package webooze.negocio.impl;

import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;
import webooze.negocio.IStrategy;

public class ValidarCamposCategoria implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Categoria categoria = (Categoria) entidade;
		if(categoria.getNome() == null || categoria.getNome().equals("")) {
			sb.append("Nome da categoria � obrigat�rio:");
		}
		if(categoria.getDiasValidade() < 0) {
			sb.append("Dias de validade inv�lidos:");
		}
		if(sb.length() > 0) {
			return sb.toString();
		}
		return null;
	}

}
