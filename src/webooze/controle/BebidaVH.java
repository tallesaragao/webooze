package webooze.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.modelo.EntidadeDominio;

public class BebidaVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setView(Object object, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String contexto = request.getContextPath();
		
		if(uri.equals(contexto + "/bebidaForm")) {
			request.getRequestDispatcher("WEB-INF/jsp/bebida/form.jsp").forward(request, response);	
		}

	}

}
