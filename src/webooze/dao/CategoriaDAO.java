package webooze.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			PreparedStatement ps = conexao.prepareStatement(sql);
			Date dataSql = new Date(categoria.getDataCadastro().getTime());
			ps.setDate(1, dataSql);
			ps.setString(2, categoria.getNome());
			ps.setInt(3, categoria.getDiasValidade());
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
			Categoria categoria = (Categoria) entidade;
			conexao = factory.getConnection();
			String sql = "update categoria set nome=?, dias_validade=? where id_categoria=?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, categoria.getNome());
			ps.setInt(2, categoria.getDiasValidade());
			ps.setLong(3, categoria.getId());
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
		List<EntidadeDominio> categorias = new ArrayList<>();
		try {
			Categoria categoria = (Categoria) entidade;
			conexao = factory.getConnection();
			String sql = "select * from categoria where nome like ?";
			if(categoria.getId() != null) {
				sql += " and id_categoria = ?";
			}
			PreparedStatement ps = conexao.prepareStatement(sql);
			if(categoria.getNome() == null) {
				categoria.setNome("");
			}
			ps.setString(1, "%" + categoria.getNome() + "%");
			if(categoria.getId() != null) {
				ps.setLong(2, categoria.getId());
			}
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				Categoria categoriaConsultada = new Categoria();
				categoriaConsultada.setId(rs.getLong("categoria.id_categoria"));
				categoriaConsultada.setDataCadastro(rs.getDate("categoria.data_cadastro"));
				categoriaConsultada.setNome(rs.getString("categoria.nome"));
				categoriaConsultada.setDiasValidade(rs.getInt("categoria.dias_validade"));
				categorias.add(categoriaConsultada);
			}
			ps.close();	
			conexao.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) {
		conexao = factory.getConnection();
		Categoria categoria = (Categoria) entidade;
		String sql = "delete from categoria where id_categoria=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, categoria.getId());
			ps.execute();
			ps.close();			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
