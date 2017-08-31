package webooze.controle;

import webooze.modelo.EntidadeDominio;

public class AlterarCommand extends AbstractCommand {

	@Override
	public Object execute(EntidadeDominio entidade) {
		return fachada.alterar(entidade);
	}

}
