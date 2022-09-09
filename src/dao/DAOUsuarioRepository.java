package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {
		private Connection connection;
	
		
	
	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarUsuario(ModelLogin modelLogin) throws SQLException {

			String sql = "INSERT INTO model_login(nome, email, login, senha) VALUES ( ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, modelLogin.getNome());
			insert.setString(2, modelLogin.getEmail());
			insert.setString(3, modelLogin.getLogin());
			insert.setString(4, modelLogin.getSenha());
			
			insert.execute();
			
			connection.commit();
			
			return this.consultarUsuario(modelLogin.getLogin());
			
	}
	
	public ModelLogin consultarUsuario(String login) throws SQLException {
	ModelLogin modelLogin = new ModelLogin();
		
		String sql = "select * from model_login where upper(login) = upper('"+login+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resutlado =  statement.executeQuery();
		
		while (resutlado.next()) /*Se tem resultado*/ {
			
			modelLogin.setId(resutlado.getLong("id"));
			modelLogin.setEmail(resutlado.getString("email"));
			modelLogin.setLogin(resutlado.getString("login"));
			modelLogin.setSenha(resutlado.getString("senha"));
			modelLogin.setNome(resutlado.getString("nome"));
		}
		
		
		return modelLogin;
		
	}
		
	
}
