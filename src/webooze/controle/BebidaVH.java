package webooze.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webooze.modelo.Bebida;
import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;
import webooze.modelo.Estoque;

public class BebidaVH implements IViewHelper {
	
	private static final String SALVAR = "SALVAR";
	private static final String CONSULTAR = "CONSULTAR";
	private static final String ALTERAR = "ALTERAR";
	private static final String EXCLUIR = "EXCLUIR";

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Bebida bebida = new Bebida();
		switch(operacao) {
			case SALVAR:
				//pegando dados do request e atribuindo a Strings
				String nome = request.getParameter("nome");
				String dataFabricacaoString = request.getParameter("dataFabricacao");
				String categoriaId = request.getParameter("categoria");
				String fornecedor = request.getParameter("fornecedor");
				String fabricante = request.getParameter("fabricante");
				String preco = request.getParameter("preco");
				String alcoolica = request.getParameter("alcoolica");
				String teorAlcool = request.getParameter("teorAlcool");
				String quantidadeAtual = request.getParameter("quantidadeAtual");
				String quantidadeMaxima = request.getParameter("quantidadeMaxima");
				String quantidadeMinima = request.getParameter("quantidadeMinima");
				String ingredientes = request.getParameter("ingredientes");
				
				if(preco == null || preco.equals("")) {
					preco = "0";
				}
				if(teorAlcool == null || teorAlcool.equals("")) {
					teorAlcool = "0";
				}
				if(quantidadeAtual == null || quantidadeAtual.equals("")) {
					quantidadeAtual = "-1";
				}
				if(quantidadeMaxima == null || quantidadeMaxima.equals("")) {
					quantidadeMaxima = "-1";
				}
				if(quantidadeMinima == null || quantidadeMinima.equals("")) {
					quantidadeMinima = "-1";
				}
				if(dataFabricacaoString == null || dataFabricacaoString.equals("")) {
					dataFabricacaoString = "0000-00-00";
				}
				
				
				//convertendo String para Date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dataFabricacao = null;
				try {
					dataFabricacao = sdf.parse(dataFabricacaoString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//setando os atributos de bebida e fazendo as conversões necessárias
				bebida.setNome(nome);
				bebida.setDataFabricacao(dataFabricacao);
				Categoria categoria = new Categoria();
				categoria.setId(Long.valueOf(categoriaId));
				bebida.setCategoria(categoria);
				bebida.setFornecedor(fornecedor);
				bebida.setFabricante(fabricante);
				bebida.setPreco(Double.valueOf(preco));
				if(alcoolica != null && alcoolica.equals("1")) {
					bebida.setAlcoolica(true);
					bebida.setTeorAlcool(Double.valueOf(teorAlcool));
				}
				else {
					bebida.setAlcoolica(false);
				}
				Estoque estoque = new Estoque();
				estoque.setQuantidadeAtual(Long.valueOf(quantidadeAtual));
				estoque.setQuantidadeMaxima(Long.valueOf(quantidadeMaxima));
				estoque.setQuantidadeMinima(Long.valueOf(quantidadeMinima));
				bebida.setEstoque(estoque);
				bebida.setIngredientes(ingredientes);
				break;
			case CONSULTAR:
				break;
			case ALTERAR:
				break;
			case EXCLUIR:
				break;
			default:
				break;
		}
		return (EntidadeDominio) bebida;
	}

	@Override
	public void setView(Object object, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		String contexto = request.getContextPath();
		
		if(uri.equals(contexto + "/bebidaForm")) {
			List<Categoria> categorias = (List<Categoria>) object;
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("WEB-INF/jsp/bebida/form.jsp").forward(request, response);	
		}
		if(uri.equals(contexto + "/bebidaSalvar")) {
			if(object == null) {
				String sucesso = "Bebida cadastrada com sucesso";
				request.setAttribute("sucesso", sucesso);
				request.getRequestDispatcher("WEB-INF/jsp/bebida/list.jsp").forward(request, response);
				return;
			}
			String mensagem = (String) object;
			String[] mensagens = mensagem.split(":");
			Bebida bebida = (Bebida) this.getEntidade(request);
			request.setAttribute("bebida", bebida);
			request.setAttribute("mensagens", mensagens);
			request.getRequestDispatcher("WEB-INF/jsp/bebida/form.jsp").forward(request, response);
		}
	}

}
