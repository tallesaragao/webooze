package webooze.controle;


public abstract class AbstractCommand implements ICommand {
	
	protected IFachada fachada = new Fachada();

}
