package webooze.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;

public class CategoriaVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String diasValidade = request.getParameter("diasValidade");
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		categoria.setDiasValidade(Integer.valueOf(diasValidade));
		return (EntidadeDominio) categoria;
	}

	@Override
	public void setView(Object object, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		System.out.println(uri);
		System.out.println(url);
		String contexto = request.getContextPath();
		if(uri.equals(contexto + "/home")) {
			request.getRequestDispatcher("WEB-INF/jsp/bebida/form.jsp").forward(request, response);			
		}
		if(uri.equals(contexto + "/categoriaForm")) {
			request.getRequestDispatcher("WEB-INF/jsp/bebida/form.jsp").forward(request, response);	
		}
		
	}

}
