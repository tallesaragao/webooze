package webooze.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webooze.modelo.Bebida;
import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;
import webooze.modelo.Estoque;

public class BebidaDAO implements IDAO {
	
	private Connection conexao;
	private ConnectionFactory factory = new ConnectionFactory();

	@Override
	public boolean salvar(EntidadeDominio entidade) {
		try {
			Bebida bebida = (Bebida) entidade;
			conexao = factory.getConnection();
			String sql = "insert into estoque(quantidade_atual, quantidade_minima, quantidade_maxima) values(?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			Estoque estoque = bebida.getEstoque();
			ps.setLong(1, estoque.getQuantidadeAtual());
			ps.setLong(2, estoque.getQuantidadeMinima());
			ps.setLong(3, estoque.getQuantidadeMaxima());
			ps.execute();
			Long idEstoque = null;
			ResultSet estoqueKeys = ps.getGeneratedKeys();
			while(estoqueKeys.next()) {
				idEstoque = estoqueKeys.getLong(1);
			}
			ps.close();
			sql = "insert into bebida"
					+ "(nome, data_fabricacao, data_validade, fornecedor, fabricante, preco, alcoolica, teor_alcool, "
					+ "consumivel, ingredientes, data_cadastro, id_categoria, id_estoque) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, bebida.getNome());
			Date dataSql = new Date(bebida.getDataFabricacao().getTime());
			ps.setDate(2, dataSql);
			dataSql = new Date(bebida.getDataValidade().getTime());
			ps.setDate(3, dataSql);
			ps.setString(4, bebida.getFornecedor());
			ps.setString(5, bebida.getFabricante());
			ps.setDouble(6, bebida.getPreco());
			ps.setBoolean(7, bebida.isAlcoolica());
			ps.setDouble(8, bebida.getTeorAlcool());
			ps.setBoolean(9, bebida.isConsumivel());
			ps.setString(10, bebida.getIngredientes());
			dataSql = new Date(bebida.getDataCadastro().getTime());
			ps.setDate(11, dataSql);
			ps.setLong(12, bebida.getCategoria().getId());
			ps.setLong(13, idEstoque);
			ps.execute();
			ps.close();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean alterar(EntidadeDominio entidade) {
		try {
			Bebida bebida = (Bebida) entidade;
			List<EntidadeDominio> consulta = consultar(bebida);
			Bebida bebidaOld = (Bebida) consulta.get(0);
			conexao = factory.getConnection();
			String sql = "update bebida set nome=?, data_fabricacao=?, data_validade=?, fornecedor=?, fabricante=?, preco=?, "
							+ "alcoolica=?, teor_alcool=?, consumivel=?, ingredientes=?, data_cadastro=? where id_categoria=?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, bebida.getNome());
			Date dataSql = new Date(bebida.getDataFabricacao().getTime());
			ps.setDate(2, dataSql);
			dataSql = new Date(bebida.getDataFabricacao().getTime());
			ps.setDate(2, dataSql);
			ps.setLong(3, bebida.getId());
			ps.execute();
			ps.close();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		List<EntidadeDominio> bebidas = new ArrayList<>();
		try {
			Bebida bebida = (Bebida) entidade;
			conexao = factory.getConnection();
			String sql = "select * from bebida "
						+ "join categoria on (bebida.id_categoria = categoria.id_categoria) "
						+ "join estoque on(bebida.id_estoque = estoque.id_estoque) "
						+ "where bebida.nome like ?";
			if(bebida.getId() != null) {
				sql += " and id_bebida = ?";
			}
			PreparedStatement ps = conexao.prepareStatement(sql);
			if(bebida.getNome() == null) {
				bebida.setNome("");
			}
			ps.setString(1, "%" + bebida.getNome() + "%");
			if(bebida.getId() != null) {
				ps.setLong(2, bebida.getId());
			}
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				Bebida bebidaConsultada = new Bebida();
				bebidaConsultada.setId(rs.getLong("bebida.id_bebida"));
				bebidaConsultada.setNome(rs.getString("bebida.nome"));
				bebidaConsultada.setDataFabricacao(rs.getDate("bebida.data_fabricacao"));
				bebidaConsultada.setDataValidade(rs.getDate("bebida.data_validade"));
				bebidaConsultada.setFornecedor(rs.getString("bebida.fornecedor"));
				bebidaConsultada.setFabricante(rs.getString("bebida.fabricante"));
				bebidaConsultada.setPreco(rs.getDouble("bebida.preco"));
				bebidaConsultada.setAlcoolica(rs.getBoolean("bebida.alcoolica"));
				bebidaConsultada.setTeorAlcool(rs.getDouble("bebida.teor_alcool"));
				bebidaConsultada.setConsumivel(rs.getBoolean("bebida.consumivel"));
				bebidaConsultada.setIngredientes(rs.getString("bebida.ingredientes"));
				bebidaConsultada.setDataCadastro(rs.getDate("bebida.data_cadastro"));
				
				Categoria categoriaConsultada = new Categoria();
				categoriaConsultada.setId(rs.getLong("categoria.id_categoria"));
				categoriaConsultada.setDataCadastro(rs.getDate("categoria.data_cadastro"));
				categoriaConsultada.setNome(rs.getString("categoria.nome"));
				categoriaConsultada.setDiasValidade(rs.getInt("categoria.dias_validade"));
				
				Estoque estoqueConsultado = new Estoque();
				estoqueConsultado.setId(rs.getLong("estoque.id_estoque"));
				estoqueConsultado.setQuantidadeAtual(rs.getLong("estoque.quantidade_atual"));
				estoqueConsultado.setQuantidadeMinima(rs.getLong("estoque.quantidade_minima"));
				estoqueConsultado.setQuantidadeMaxima(rs.getLong("estoque.quantidade_maxima"));
				estoqueConsultado.setDataCadastro(rs.getDate("bebida.data_cadastro"));
				
				bebidaConsultada.setCategoria(categoriaConsultada);
				bebidaConsultada.setEstoque(estoqueConsultado);
				
				bebidas.add(bebidaConsultada);
			}
			ps.close();	
			conexao.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return bebidas;
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) {
		Bebida bebida = (Bebida) entidade;
		List<EntidadeDominio> consulta = consultar(bebida);
		bebida = (Bebida) consulta.get(0);
		conexao = factory.getConnection();
		String sql = "delete from bebida where id_bebida=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, bebida.getId());
			ps.execute();
			ps.close();
			sql = "delete from estoque where id_estoque=?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, bebida.getEstoque().getId());
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
