package webooze.negocio.impl;

import java.util.Calendar;
import java.util.List;

import webooze.dao.CategoriaDAO;
import webooze.modelo.Bebida;
import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;
import webooze.negocio.IStrategy;

public class GerarDataValidade implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Bebida bebida = (Bebida) entidade;
		Categoria categoria = bebida.getCategoria();
		CategoriaDAO dao = new CategoriaDAO();
		List<EntidadeDominio> consulta = dao.consultar(categoria);
		for(EntidadeDominio ent : consulta) {
			categoria = (Categoria) ent;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(bebida.getDataFabricacao());
		cal.add(Calendar.DAY_OF_MONTH, categoria.getDiasValidade());
		bebida.setDataValidade(cal.getTime());
		return null;
	}

}
