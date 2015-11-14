package br.com.livraria.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ListaEditoras 
{

	public static void main(String[] args) 
	{
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "admin";

		try 
		{
			System.out.println("Abrindo conexão...");
			Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);
			
			String sql = "SELECT * FROM Editora";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultados encontrados: \n");
			while(resultado.next())
			{
				System.out.printf("%d : %s - %s\n", 
									resultado.getInt("id"),
									resultado.getString("nome"),
									resultado.getString("email"));
			}
			
			System.out.println("Fechando conexão...");
			conexao.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
