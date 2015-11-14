package br.com.livraria.jdbc.factory;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory 
{
	private static Connection conexao = null;
	
	public static Connection createConnection()
	{
		if (conexao == null)
		{
			String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
			String usuario = "root";
			String senha = "admin";
	
			conexao = null;
			
			try 
			{
				conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return conexao;
	}
}
