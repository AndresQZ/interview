package com.interview.model.service;

import java.util.List;

import com.interview.model.Client;
import com.interview.rest.exceptions.BadRequest;
import com.interview.rest.exceptions.UserNotFound;

public interface IClientService {

	public List<Client> getAllClient();
	
	public Client getClientById(int id);
	
	 String addClient(Client client);
	 
	 public void updateClient(Client client) throws BadRequest , UserNotFound;
	 
	 public String deleteClient(int id);
}
