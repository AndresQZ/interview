package com.interview.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interview.model.Client;
import com.interview.rest.exceptions.UserNotFound;
import com.interview.util.Utils;

@Repository
public class ClientDaoImpl implements Dao<Client> {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	

	@Transactional
	@Override
	public void save(Client client) {
		entityManager.persist(client);
	}

	@Override
	public Client load(int id) {
		return entityManager.find(Client.class, id);
	}

	@Transactional
	@Override
	public void delete(int id) {
	      Query query = entityManager.createQuery("DELETE FROM Client c WHERE c.id = :idClient ");
	      query.setParameter("idClient", id);
	      int rowsDeleted = query.executeUpdate();
	      System.out.println("Client deleted: " + rowsDeleted);
	}
	
	
	
	@Transactional
	@Override
	public void update(Client client) throws UserNotFound{
	 
		Client user = entityManager.find(Client.class, client.getId());
		  if(user != null) {
			  user = client;
			  entityManager.merge(user);
			} else {
				throw new UserNotFound("user not found");
			}   	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> loadAll() {
		Query query = entityManager.createNamedQuery("query_find_all_client", Client.class);
		
		return query.getResultList();
		
	}
	
	
 
}
