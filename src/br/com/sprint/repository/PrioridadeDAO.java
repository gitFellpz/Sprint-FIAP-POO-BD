package br.com.sprint.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sprint.connection.ConnectionFactory;
import br.com.sprint.model.Prioridade;

public class PrioridadeDAO {
	
private Connection conexao;
	
	public PrioridadeDAO() throws SQLException {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void insert(Prioridade prioridade) throws SQLException {
		String sql = "insert into PRIORIDADE (nome, descricao) values(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, prioridade.getNome());
		stmt.setString(2, prioridade.getDescricao());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void update(Prioridade prioridade) throws SQLException {
		String sql = "update PRIORIDADE set nome=?, descricao=? where cod_categoria=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, prioridade.getNome());
		stmt.setString(2, prioridade.getDescricao());
		stmt.setInt(3, prioridade.getCodPrioridade());

		stmt.execute();		
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from PRIORIDADE where cod_prioridade=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();		
		stmt.close();
	}
	
	public List<Prioridade> selectAll() throws SQLException {
		List<Prioridade> prioridades = new ArrayList<Prioridade>();
		
		String sql = "select * from PRIORIDADES";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Prioridade prioridade = new Prioridade();
			prioridade.setCodPrioridade(rs.getInt("cod_prioridade"));
			prioridade.setNome(rs.getString("nome"));
			prioridade.setDescricao(rs.getString("descricao"));

			prioridades.add(prioridade);
		}
				
		stmt.close();
		rs.close();
		return prioridades;
	}

}
