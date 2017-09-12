package webooze.negocio.impl;

import java.util.Date;

import webooze.modelo.Bebida;
import webooze.modelo.EntidadeDominio;
import webooze.negocio.IStrategy;

public class VerificarValidade implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Bebida bebida = (Bebida) entidade;
		bebida.setConsumivel(true);
		Date dataDoSistema = new Date();
		if(dataDoSistema.getTime() >= bebida.getDataValidade().getTime()) {
			bebida.setConsumivel(false);
		}
		return null;
	}

}
