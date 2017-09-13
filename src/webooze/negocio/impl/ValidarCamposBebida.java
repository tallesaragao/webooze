package webooze.negocio.impl;

import webooze.modelo.Bebida;
import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;
import webooze.modelo.Estoque;
import webooze.negocio.IStrategy;

public class ValidarCamposBebida implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Bebida bebida = (Bebida) entidade;
		Categoria categoria = bebida.getCategoria();
		Estoque estoque = bebida.getEstoque();
		if(bebida.getNome() == null || bebida.getNome().equals("")) {
			sb.append("Nome da categoria � obrigat�rio:");
		}
		if(bebida.getDataFabricacao() == null) {
			sb.append("Data de fabrica��o inv�lida:");
		}
		if(categoria == null) {
			sb.append("Categoria inv�lida:");
		}
		if(bebida.getFornecedor() == null || bebida.getFornecedor().equals("")) {
			sb.append("Fornecedor � obrigat�rio:");
		}
		if(bebida.getFabricante() == null || bebida.getFabricante().equals("")) {
			sb.append("Fabricante � obrigat�rio:");
		}
		if(bebida.getPreco() <= 0) {
			sb.append("Pre�o deve ser maior que zero:");
		}
		if(bebida.isAlcoolica() && bebida.getTeorAlcool() <= 0) {
			sb.append("Informe corretamente o teor de �lcool da bebida:");
		}
		if(estoque.getQuantidadeAtual() < 0 || estoque.getQuantidadeMaxima() <= 0 || estoque.getQuantidadeMinima() < 0) {
			sb.append("Quantidades inv�lidas:");
		}
		else {
			if(estoque.getQuantidadeAtual() < estoque.getQuantidadeMinima() || estoque.getQuantidadeAtual() > estoque.getQuantidadeMaxima()) {
				sb.append("Quantidade em estoque deve estar dentro dos limites:");
			}
		}
		if(bebida.getIngredientes() == null || bebida.getIngredientes().equals("")) {
			sb.append("Ingredientes devem ser informados:");
		}
		if(sb.length() > 0) {
			return sb.toString();
		}
		return null;
	}

}
