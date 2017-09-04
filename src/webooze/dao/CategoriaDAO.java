package webooze.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import webooze.modelo.Categoria;
import webooze.modelo.EntidadeDominio;

public class CategoriaDAO implements IDAO {
	
	private Connection conexao;
	private ConnectionFactory factory = new ConnectionFactory();

	@Override
	public boolean salvar(EntidadeDominio entidade) {
		try {
			Categoria categoria = (Categoria) entidade;
			conexao = factory.getConnection();
			String sql = "insert into categoria(data_cadastro, nome, dias_validade) values(?,?,?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			Date dataSql = new Date(categoria.getDataCadastro().getTime());
			stmt.setDate(1, dataSql);
			stmt.setString(2, categoria.getNome());
			stmt.setInt(3, categoria.getDiasValidade());
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
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
		// TODO Auto-generated method stub
		return false;
	}

}
