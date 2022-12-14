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

		if (modelLogin.isNovo()) {/*Grava um novo*/
			String sql = "INSERT INTO model_login(nome, email, login, senha) VALUES ( ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, modelLogin.getNome());
			insert.setString(2, modelLogin.getEmail());
			insert.setString(3, modelLogin.getLogin());
			insert.setString(4, modelLogin.getSenha());
			
			insert.execute();
			
			connection.commit();
			
		}else {
			String sql = "UPDATE model_login SET login=?, senha=?, nome=?, email=? WHERE id =  "+modelLogin.getId()+";";
			
			PreparedStatement prepareSql = connection.prepareStatement(sql);
			
			prepareSql.setString(1, modelLogin.getLogin());
			prepareSql.setString(2, modelLogin.getSenha());
			prepareSql.setString(3, modelLogin.getNome());
			prepareSql.setString(4, modelLogin.getEmail());
			
			prepareSql.executeUpdate();
			
			connection.commit();
			
		}
			
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
	
	

	public boolean validarLogin(String login) throws Exception {
		String sql = "select count(1) > 0 as existe from model_login where upper(login) = upper('"+login+"');";
		
        PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resutlado =  statement.executeQuery();
		
		resutlado.next();/*Pra ele entrar nos resultados do sql*/
		return resutlado.getBoolean("existe");
		
	}
	
	public void deletarUser(String idUser) throws Exception {
		String sql = "DELETE FROM model_login WHERE id = ?;";
		
		PreparedStatement prepareSql = connection.prepareStatement(sql);
		
		prepareSql.setLong(1, Long.parseLong(idUser));
		
		prepareSql.executeUpdate();
		
		connection.commit();
		
	}

		
	
}
