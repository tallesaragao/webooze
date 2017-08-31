package webooze.controle;

import webooze.modelo.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand {

	@Override
	public Object execute(EntidadeDominio entidade) {
		return fachada.excluir(entidade);
	}

}
