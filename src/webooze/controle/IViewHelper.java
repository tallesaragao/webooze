package webooze.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.modelo.EntidadeDominio;

public interface IViewHelper {
	public EntidadeDominio getEntidade(HttpServletRequest request);

	public void setView(Object object, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
