package com.interview.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.model.Client;
import com.interview.model.dao.Dao;
import com.interview.rest.exceptions.BadRequest;
import com.interview.rest.exceptions.UserNotFound;
import com.interview.util.Utils;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private Dao<Client> dao;
	
	@Autowired
	private Utils utils;

	@Override
	public List<Client> getAllClient() {
		 
		List<Client> listClients = null;
		listClients = dao.loadAll();
		
		return listClients;
	}



	@Override
	public Client getClientById(int id) {
		return dao.load(id);
	}


	@Override
	public String addClient(Client client) {
		 dao.save(client);
		
		return "ok";
	}



	@Override
	public void updateClient(Client client) throws BadRequest, UserNotFound {
		if (utils.hasValidIdClient(client)) {
		  dao.update(client);	
		}  else {
			throw new BadRequest("invalid idclient");
		}
		
	}



	@Override
	public String deleteClient(int id) {
		dao.delete(id);
		return "ok";
	}

}
