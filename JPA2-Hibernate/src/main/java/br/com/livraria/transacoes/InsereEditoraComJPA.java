package br.com.livraria.transacoes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.entidade.Editora;
import br.com.livraria.repositorio.EditoraRepository;

public class InsereEditoraComJPA 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository repository = new EditoraRepository(manager);
		
		Editora novaEditora = new Editora();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da editora: ");
		novaEditora.setNome(entrada.nextLine());
		
		System.out.println("Digite o email da editora: ");
		novaEditora.setEmail(entrada.nextLine());
		
		repository.adiciona(novaEditora);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
