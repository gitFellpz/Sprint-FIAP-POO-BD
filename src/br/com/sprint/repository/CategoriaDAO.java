package br.com.sprint.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sprint.connection.ConnectionFactory;
import br.com.sprint.model.Categoria;

public class CategoriaDAO {
	
	private Connection conexao;
	
	public CategoriaDAO() throws SQLException {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void insert(Categoria categoria) throws SQLException {
		String sql = "insert into CATEGORIA (nome, descricao)values(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, categoria.getNome());
		stmt.setString(2, categoria.getDescricao());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void update(Categoria categoria) throws SQLException {
		String sql = "update CATEGORIA set nome=?, descricao=? where cod_categoria=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, categoria.getNome());
		stmt.setString(2, categoria.getDescricao());
		stmt.setInt(3, categoria.getCodCategoria());

		stmt.execute();		
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from CATEGORIA where cod_categoria=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();		
		stmt.close();
	}
	
	public List<Categoria> selectAll() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "select * from categoria";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setCodCategoria(rs.getInt("cod_categoria"));
			categoria.setNome(rs.getString("nome"));
			categoria.setDescricao(rs.getString("descricao"));

			categorias.add(categoria);
		}
				
		stmt.close();
		rs.close();
		return categorias;
	}

}
