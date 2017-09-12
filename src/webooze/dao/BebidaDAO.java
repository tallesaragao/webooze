package webooze.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
					+ "(nome, data_fabricacao, data_validade, fornecedor, fabricante, preco, alcoolica, "
					+ "teor_alcool, consumivel, data_cadastro, id_categoria, id_estoque) values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
			dataSql = new Date(bebida.getDataCadastro().getTime());
			ps.setDate(10, dataSql);
			ps.setLong(11, bebida.getCategoria().getId());
			ps.setLong(12, idEstoque);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) {
		conexao = factory.getConnection();
		Bebida bebida = (Bebida) entidade;
		String sql = "delete from estoque where id_bebida=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, bebida.getId());
			ps.execute();
			ps.close();
			sql = "delete from bebida where id_bebida=?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, bebida.getId());
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
