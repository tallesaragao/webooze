package webooze.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webooze.dao.IDAO;
import webooze.modelo.EntidadeDominio;
import webooze.negocio.IStrategy;
import webooze.negocio.impl.ComplementarDtCadastro;

public class Fachada implements IFachada {

	private static final String SALVAR = "SALVAR";
	private static final String ALTERAR = "ALTERAR";
	private static final String CONSULTAR = "CONSULTAR";
	private static final String EXCLUIR = "EXCLUIR";

	private Map<String, Map<String, List<IStrategy>>> requisitos;
	private Map<String, IDAO> daos;

	public Fachada() {
		ComplementarDtCadastro compDtCad = new ComplementarDtCadastro();

		List<IStrategy> lSalvarFunc = new ArrayList<IStrategy>();
		lSalvarFunc.add(compDtCad);
		
		List<IStrategy> lAlterarFunc = new ArrayList<IStrategy>();
		
		List<IStrategy> lExcluirFunc = new ArrayList<IStrategy>();
		
		List<IStrategy> lConsultarFunc = new ArrayList<IStrategy>();
		
		List<IStrategy> lSalvarCliente = new ArrayList<IStrategy>();
		lSalvarCliente.add(compDtCad);
		
		List<IStrategy> lAlterarCliente = new ArrayList<IStrategy>();
		
		List<IStrategy> lExcluirCliente = new ArrayList<IStrategy>();
		
		List<IStrategy> lConsultarCliente = new ArrayList<IStrategy>();

		Map<String, List<IStrategy>> contextoFunc = new HashMap<String, List<IStrategy>>();
		contextoFunc.put(SALVAR, lSalvarFunc);
		contextoFunc.put(ALTERAR, lAlterarFunc);
		contextoFunc.put(EXCLUIR, lExcluirFunc);
		contextoFunc.put(CONSULTAR, lConsultarFunc);
		
		Map<String, List<IStrategy>> contextoCli = new HashMap<String, List<IStrategy>>();
		contextoCli.put(SALVAR, lSalvarCliente);
		contextoCli.put(ALTERAR, lAlterarCliente);
		contextoCli.put(EXCLUIR, lExcluirCliente);
		contextoCli.put(CONSULTAR, lConsultarCliente);

		requisitos = new HashMap<String, Map<String, List<IStrategy>>>();
		
		daos = new HashMap<String, IDAO>();
	}

	@Override
	public String salvar(EntidadeDominio entidade) {
		StringBuilder sb = executarRegras(entidade, SALVAR);
		if (sb.length() > 0) {
			return sb.toString();
		}
		IDAO dao = daos.get(entidade.getClass().getName());
		if(!dao.salvar(entidade)) {
			return "Erro ao persistir a entidade";
		}
		return null;
		
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
		StringBuilder sb = executarRegras(entidade, ALTERAR);
		if (sb.length() > 0) {
			return sb.toString();
		}
		if(!dao.alterar(entidade)) {
			return "Problema na altera��o";
		}
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
		if (!dao.excluir(entidade)) {
			return "Problema na exclus�o";
		}
		return "Exclus�o efetuada com sucesso";
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		IDAO dao = daos.get(entidade.getClass().getName());
		List<EntidadeDominio> consulta = dao.consultar(entidade);
		if(consulta.isEmpty()) {
			return null;
		}
		return consulta;
	}

	private StringBuilder executarRegras(EntidadeDominio entidade, String operacao) {
		StringBuilder sb = new StringBuilder();
		Map<String, List<IStrategy>> contextoEntidade = requisitos.get(entidade.getClass().getName());
		List<IStrategy> reqs = contextoEntidade.get(operacao);
		for (IStrategy req : reqs) {
			String msg = req.processar(entidade);
			if (msg != null) {
				sb.append(msg);
			}
		}
		return sb;
	}

}
