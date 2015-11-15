package br.com.livraria.transacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.livraria.entidade.Editora;

public class ListaEditoraComJPA 
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager manager = factory.createEntityManager();
		
		Query query = (Query) manager.createQuery("SELECT e FROM Editora e");
		
		List<Editora> editoras = query.getResultList();
		
		for (Editora editora : editoras) 
		{
			System.out.println("EDITORA: " + editora.getNome() + " - " + editora.getEmail());
		}
		
		manager.close();
		factory.close();
	}

}
