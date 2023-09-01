package br.com.sprint.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;
	
	private ConnectionFactory() {
		
	}

	public static Connection conectar() throws SQLException{
		if(conexao == null) {
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(ORACLE);
			comboPooledDataSource.setUser("rm93167");
			comboPooledDataSource.setPassword("110804");
			
			//Número máximo de conexões
			comboPooledDataSource.setMaxPoolSize(20);
			conexao = comboPooledDataSource;
		}
		
		return conexao.getConnection();
	};
}
