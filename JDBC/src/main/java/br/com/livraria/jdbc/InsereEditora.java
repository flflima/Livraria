package br.com.livraria.jdbc;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereEditora 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "admin";
		
		Scanner entrada = new Scanner(System.in);
		
		try 
		{
			System.out.println("Abrindo conex�o...");
			Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);
			
			System.out.println("Digite o nome da editora: ");
			String nome = entrada.nextLine();
			
			System.out.println("Digite o email da editora: ");
			String email = entrada.nextLine();
			
			String sql = "INSERT INTO Editora (nome, email) VALUES ('" + nome + "', '" + email + "')";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			comando.execute();
			
			System.out.println("Fechando conex�o...");
			conexao.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
