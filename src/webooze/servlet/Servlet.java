package webooze.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.controle.AlterarCommand;
import webooze.controle.BebidaVH;
import webooze.controle.CategoriaVH;
import webooze.controle.ConsultarCommand;
import webooze.controle.ExcluirCommand;
import webooze.controle.ICommand;
import webooze.controle.IViewHelper;
import webooze.controle.SalvarCommand;
import webooze.modelo.EntidadeDominio;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, IViewHelper> vhs;
	private Map<String, ICommand> commands;
	
	public Servlet() {
		commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("ALTERAR", new AlterarCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		
		String contextoApp = "/webooze";
		
		vhs = new HashMap<String, IViewHelper>();
		vhs.put(contextoApp + "/home", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaForm", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaList", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaEdit", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaSalvar", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaConsultar", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaAlterar", new CategoriaVH());
		vhs.put(contextoApp + "/categoriaExcluir", new CategoriaVH());
		vhs.put(contextoApp + "/bebidaForm", new BebidaVH());
		vhs.put(contextoApp + "/bebidaList", new BebidaVH());
		vhs.put(contextoApp + "/bebidaEdit", new BebidaVH());
		vhs.put(contextoApp + "/bebidaSalvar", new BebidaVH());
		vhs.put(contextoApp + "/bebidaConsultar", new BebidaVH());
		vhs.put(contextoApp + "/bebidaAlterar", new BebidaVH());
		vhs.put(contextoApp + "/bebidaExcluir", new BebidaVH());
	}
		
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		Object obj = null;
		String uri = request.getRequestURI();
		IViewHelper vh = vhs.get(uri);
		if(vh != null) {
			if(operacao != null && !operacao.equals("")) {
				EntidadeDominio entidade = vh.getEntidade(request);
				ICommand cmd = commands.get(operacao);
				obj = cmd.execute(entidade);
			}
			vh.setView(obj, request, response);
		}
	}
}
