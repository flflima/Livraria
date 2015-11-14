package br.com.livraria.jdbc;

import java.util.Scanner;

import br.com.livraria.jdbc.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AlteraEditora 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();
			
			System.out.println("Digite o novo nome da editora: ");
			String nome = entrada.nextLine();
			
			System.out.println("Digite o novo email da editora: ");
			String email = entrada.nextLine();
			
			System.out.println("Digite o id da editora: ");
			int idEditora = entrada.nextInt();
			
			String sql = "UPDATE Editora SET nome = ?, email = ? WHERE id = ?";
			
			PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
			
			comando.setString(1, nome);
			comando.setString(2, email);
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
