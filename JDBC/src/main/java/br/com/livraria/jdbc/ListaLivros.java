package br.com.livraria.jdbc;

import java.sql.ResultSet;

import br.com.livraria.jdbc.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ListaLivros
{

	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "SELECT * FROM Livro";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultados encontrados: \n");
			while(resultado.next())
			{
				System.out.printf("%d : %s - %.2f\n", 
									resultado.getInt("id"),
									resultado.getString("titulo"),
									resultado.getDouble("preco"));
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
