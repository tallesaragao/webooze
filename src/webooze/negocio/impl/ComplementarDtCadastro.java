package webooze.negocio.impl;

import java.util.Date;

import webooze.modelo.EntidadeDominio;
import webooze.negocio.IStrategy;

public class ComplementarDtCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		entidade.setDataCadastro(new Date());
		return null;
	}

}
