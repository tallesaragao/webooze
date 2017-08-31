package webooze.controle;

import webooze.modelo.EntidadeDominio;

public class ConsultarCommand extends AbstractCommand {

	@Override
	public Object execute(EntidadeDominio entidade) {
		return fachada.consultar(entidade);
	}

}
