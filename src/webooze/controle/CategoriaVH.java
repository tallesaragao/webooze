package webooze.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;

public class CategoriaVH implements IViewHelper {
	
	private static final String SALVAR = "SALVAR";
	private static final String CONSULTAR = "CONSULTAR";
	private static final String ALTERAR = "ALTERAR";
	private static final String EXCLUIR = "EXCLUIR";

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Categoria categoria = new Categoria();
		String operacao = request.getParameter("operacao");
		
		if(operacao.equals(CONSULTAR)) {
			String id = request.getParameter("id");
			String busca = request.getParameter("busca");
			categoria.setNome("");
			if(busca != null) {
				categoria.setNome(busca);
			}
			if(id != null) {
				categoria.setId(Long.valueOf(id));
			}
		}
		else if(operacao.equals(EXCLUIR)) {
			String id = request.getParameter("id");
			if(id != null && !id.equals("")) {
				categoria.setId(Long.valueOf(id));
			}
		}
		else if(operacao.equals(ALTERAR)) {
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String diasValidade = request.getParameter("diasValidade");
			categoria.setId(Long.valueOf(id));
			categoria.setNome(nome);
			categoria.setDiasValidade(0);
			//verifica se o valor informado está preenchido e é numérico
			if(diasValidade.length() > 0 && Character.isDigit(diasValidade.charAt(0))) {
				categoria.setDiasValidade(Integer.valueOf(diasValidade));
			}
		}
		else {
			String nome = request.getParameter("nome");
			String diasValidade = request.getParameter("diasValidade");
			categoria.setNome(nome);
			categoria.setDiasValidade(0);
			//verifica se o valor informado está preenchido e é numérico
			if(diasValidade.length() > 0 && Character.isDigit(diasValidade.charAt(0))) {
				categoria.setDiasValidade(Integer.valueOf(diasValidade));
			}
		}
		
		return (EntidadeDominio) categoria;
	}

	@Override
	public void setView(Object object, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String contexto = request.getContextPath();
		
		if(uri.equals(contexto + "/home")) {
			request.getRequestDispatcher("WEB-INF/jsp/categoria/form.jsp").forward(request, response);			
		}
		
		if(uri.equals(contexto + "/categoriaForm")) {
			request.getRequestDispatcher("WEB-INF/jsp/categoria/form.jsp").forward(request, response);	
		}
		
		if(uri.equals(contexto + "/categoriaList")) {
			request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);	
		}
		
		if(uri.equals(contexto + "/categoriaEdit")) {
			List<Categoria> lista = (List<Categoria>) object;
			Categoria categoria = lista.get(0);
			request.setAttribute("categoria", categoria);
			request.setAttribute("operacao", ALTERAR);
			request.getRequestDispatcher("WEB-INF/jsp/categoria/form.jsp").forward(request, response);
		}	
		
		if(uri.equals(contexto + "/categoriaSalvar")) {
			if(object == null) {
				String sucesso = "Categoria cadastrada com sucesso";
				request.setAttribute("sucesso", sucesso);
				request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);
				return;
			}
			String mensagem = (String) object;
			String[] mensagens = mensagem.split(":");
			Categoria categoria = (Categoria) this.getEntidade(request);
			request.setAttribute("categoria", categoria);
			request.setAttribute("mensagens", mensagens);
			request.getRequestDispatcher("WEB-INF/jsp/categoria/form.jsp").forward(request, response);
		}
		
		if(uri.equals(contexto + "/categoriaConsultar")) {
			if(object == null) {
				String erro = "Nenhuma categoria encontrada";
				request.setAttribute("erro", erro);
				request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);
				return;
			}
			List<Categoria> consulta = (List<Categoria>) object;
			request.setAttribute("consulta", consulta);
			request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);
		}
		
		if(uri.equals(contexto + "/categoriaAlterar")) {
			if (object != null) {
				String mensagem = (String) object;
				String[] mensagens = mensagem.split(":");
				Categoria categoria = (Categoria) this.getEntidade(request);
				request.setAttribute("mensagens", mensagens);
				request.setAttribute("categoria", categoria);
				request.setAttribute("operacao", ALTERAR);
				request.getRequestDispatcher("WEB-INF/jsp/categoria/form.jsp").forward(request, response);
				return;
			}
			String sucesso = "Alteração efetuada com sucesso";
			request.setAttribute("sucesso", sucesso);
			request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);
			return;
		}
		
		if(uri.equals(contexto + "/categoriaExcluir")) {
			String sucesso = (String) object;
			request.setAttribute("sucesso", sucesso);
			request.getRequestDispatcher("WEB-INF/jsp/categoria/list.jsp").forward(request, response);
		}
	}

}
