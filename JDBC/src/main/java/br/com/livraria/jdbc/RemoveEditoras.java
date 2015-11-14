package br.com.livraria.jdbc;

import java.util.Scanner;

import br.com.livraria.jdbc.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RemoveEditoras
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			System.out.println("Digite o id da editora: ");
			int idEditora = entrada.nextInt();
			
			String sql = "DELETE FROM Editora WHERE id = ?";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			comando.setInt(1, idEditora);
		
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
