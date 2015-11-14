package br.com.livraria.jdbc;

import java.util.Scanner;

import br.com.livraria.jdbc.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsereEditora 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		
		try 
		{
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			System.out.println("Digite o nome da editora: ");
			String nome = entrada.nextLine();
			
			System.out.println("Digite o email da editora: ");
			String email = entrada.nextLine();
			
			String sql = "INSERT INTO Editora (nome, email) VALUES (?, ?)";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			comando.setString(1, nome);
			comando.setString(2, email);
			
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
