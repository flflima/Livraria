package br.com.livraria.jdbc.factory;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory 
{
	public static Connection createConnection()
	{

		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "admin";

		Connection conexao = null;
		
		try 
		{
			conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return conexao;
	}
}
