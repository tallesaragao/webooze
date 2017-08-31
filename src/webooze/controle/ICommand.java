package webooze.controle;

import webooze.modelo.EntidadeDominio;

public interface ICommand {
	
	Object execute(EntidadeDominio entidade);
	
}
