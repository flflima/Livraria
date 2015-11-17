package br.com.livraria.transacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.livraria.entidade.Editora;
import br.com.livraria.repositorio.EditoraRepository;

public class ListaEditoraComJPA 
{

	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository repository = new EditoraRepository(manager);
		
		List<Editora> editoras = repository.buscaTodas();
		
		for (Editora editora : editoras) 
		{
			System.out.println("EDITORA: " + editora.getNome() + " - " + editora.getEmail());
		}
		
		manager.close();
		factory.close();
	}

}
