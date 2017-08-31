package webooze.negocio;

import webooze.modelo.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
