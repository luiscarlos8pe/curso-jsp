package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection connection;
	
	public DAOLoginRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws SQLException {
		
			String sql = "select * from model_login where login = ? and senha = ? ";
			PreparedStatement consulta = connection.prepareStatement(sql);
			
			consulta.setString(1, modelLogin.getLogin());
			consulta.setString(2, modelLogin.getSenha());
			
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				return true;
			}else {
				return false;
			}		
	}
}
