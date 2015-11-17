package br.com.livraria.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livraria.entidade.Editora;

public class EditoraRepository
{
	private EntityManager manager;

	public EditoraRepository(EntityManager manager) 
	{
		this.manager = manager;
	}
	
	public void adiciona(Editora e)
	{
		this.manager.persist(e);
	}
	
	public Editora busca(Long id)
	{
		Editora e = this.manager.find(Editora.class, id);
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public List<Editora> buscaTodas()
	{
		Query query = this.manager.createQuery("SELECT e FROM Editora e");
		List<Editora> editoras = query.getResultList();
		return editoras;
	}
}
