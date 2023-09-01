package br.com.sprint.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sprint.connection.ConnectionFactory;
import br.com.sprint.model.Feedback;

public class FeedbackDAO {
	
	private Connection conexao;
	
	public FeedbackDAO() throws SQLException {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void insert(Feedback feedback) 
			throws SQLException {
		String sql = "insert into FEEDBACK (mensagem, data_envio, hora_envio, likes, cod_categoria, cod_usuario, cod_prioridade) values(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, feedback.getMensagem());
		stmt.setDate(2, feedback.getDataEnvio());
		stmt.setDate(3, feedback.getHoraEnvio());
		stmt.setInt(4, feedback.getLikes());
		
		stmt.setInt(5, feedback.getCodCategoria());
		stmt.setInt(6, feedback.getCodUsuario());
		stmt.setInt(7, feedback.getCodPrioridade());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void update(Feedback feedback) throws SQLException {
		String sql = "update FEEDBACK set mensagem=?, data_envio=?, hora_envio=?, likes=?, cod_categoria=?, cod_usuario=?, cod_prioridade=? where cod_feedback=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, feedback.getMensagem());
		stmt.setDate(2, feedback.getDataEnvio());
		stmt.setDate(3, feedback.getHoraEnvio());
		stmt.setInt(4, feedback.getLikes());
		
		stmt.setInt(5, feedback.getCodCategoria());
		stmt.setInt(6, feedback.getCodUsuario());
		stmt.setInt(7, feedback.getCodPrioridade());
		
		stmt.setInt(8, feedback.getCodFeedback());

		stmt.execute();		
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from FEEDBACK where cod_feedback=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();		
		stmt.close();
	}
	
	public List<Feedback> selectAll() throws SQLException {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		
		String sql = "select * from feedback";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Feedback feedback = new Feedback();
			feedback.setCodFeedback(rs.getInt("cod_feedback"));
			feedback.setMensagem(rs.getString("mensagem"));
			feedback.setDataEnvio(rs.getDate("data_envio"));
			feedback.setHoraEnvio(rs.getDate("hora_envio"));
			feedback.setLikes(rs.getInt("likes"));
			
			feedback.setCodCategoria(rs.getInt("cod_categoria"));
			feedback.setCodUsuario(rs.getInt("cod_usuario"));
			feedback.setCodPrioridade(rs.getInt("cod_prioridade"));

			feedbacks.add(feedback);
		}
				
		stmt.close();
		rs.close();
		return feedbacks;
	}
}
