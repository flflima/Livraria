package br.com.livraria.jdbc;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereLivro 
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
			System.out.println("Abrindo conexão...");
			Connection conexao = (Connection) DriverManager.getConnection(stringDeConexao, usuario, senha);
			
			System.out.println("Digite o nome do título do livro: ");
			String titulo = entrada.nextLine();

			System.out.println("Digite o preço do livro: ");
			double preco = entrada.nextDouble();
			
			System.out.println("Digite o id da editora: ");
			int idEditora = entrada.nextInt();
			
			String sql = "INSERT INTO Livro (titulo, preco, editora_id) VALUES ('" + titulo +"', " + preco + ", " + idEditora + ")";

			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Executando comando...");
			comando.execute();
			
			System.out.println("Fechando conexão...");
			conexao.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
