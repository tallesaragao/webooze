package webooze.controle;

import webooze.modelo.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {

	@Override
	public Object execute(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}

}
