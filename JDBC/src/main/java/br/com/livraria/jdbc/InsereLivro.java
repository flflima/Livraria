package br.com.livraria.jdbc;

import java.util.Scanner;

import br.com.livraria.jdbc.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereLivro 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);

		try 
		{
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			System.out.println("Digite o nome do título do livro: ");
			String titulo = entrada.nextLine();

			System.out.println("Digite o preço do livro: ");
			double preco = entrada.nextDouble();
			
			System.out.println("Digite o id da editora: ");
			int idEditora = entrada.nextInt();
			
			String sql = "INSERT INTO Livro (titulo, preco, editora_id) VALUES (?, ?, ?)";

			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			comando.setString(1, titulo);
			comando.setDouble(2, preco);
			comando.setInt(3, idEditora);
			
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
