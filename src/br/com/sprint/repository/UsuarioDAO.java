package br.com.sprint.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sprint.connection.ConnectionFactory;
import br.com.sprint.model.Usuario;

public class UsuarioDAO {
private Connection conexao;
	
	public UsuarioDAO() throws SQLException {
		this.conexao = ConnectionFactory.conectar();
	}
	
	//inserir um usuario
	public void insert(Usuario usuario) throws SQLException {
		String sql = "insert into USUARIO (primeiro_nome, meio_nome, ultimo_nome, email)values(?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getPrimeiroNome());
		stmt.setString(2, usuario.getMeioNome());
		stmt.setString(3, usuario.getUltimoNome());
		stmt.setString(4, usuario.getEmail());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void update(Usuario usuario) throws SQLException {
		String sql = "update USUARIO set primeiro_nome=?, meio_nome=?, ultimo_nome=?, email=? where cod_usuario=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getPrimeiroNome());
		stmt.setString(2, usuario.getMeioNome());
		stmt.setString(3, usuario.getUltimoNome());
		stmt.setString(4, usuario.getEmail());
		
		stmt.setInt(5, usuario.getCodUsuario());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from USUARIO where cod_usuario=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();		
		stmt.close();
	}
	
	public List<Usuario> selectAll() throws SQLException {
			
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setCodUsuario(rs.getInt("cod_usuario"));
			usuario.setPrimeiroNome(rs.getString("primeiro_nome"));
			usuario.setMeioNome(rs.getString("meio_nome"));
			usuario.setUltimoNome(rs.getString("ultimo_nome"));
			usuario.setEmail(rs.getString("email"));
			
			usuarios.add(usuario);
		}
				
		stmt.close();
		rs.close();
		return usuarios;
	}
}
