package com.interview.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.Client;
import com.interview.model.service.ClientService;
import com.interview.requestmapping.GenericResponse;
import com.interview.requestmapping.User;

@RestController
@RequestMapping(value="/client/v0/")
public class ClientController {
	
	GenericResponse genericResponse = new GenericResponse();
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="{idclient}", method = RequestMethod.GET) 
	public ResponseEntity<Object> getClient(@PathVariable("idclient") int id) {
		
		Client client = null;
		client = clientService.getClientById(id);
		
		if (client ==null) {
			return new ResponseEntity<Object>(genericResponse,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(client,HttpStatus.OK );
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllClients() {
		
		List<Client> clients = null;
		clients = clientService.getAllClient();
		
		if (clients ==null) {
			return new ResponseEntity<Object>(genericResponse,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(clients,HttpStatus.OK );	
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.POST) 
	public ResponseEntity<Object> createClient(@RequestBody Client user) {
		
		clientService.addClient(user);
		return new ResponseEntity<Object>(genericResponse, HttpStatus.NO_CONTENT );
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT) 
	public ResponseEntity<Object> updateClient(@RequestBody Client client) throws Exception {
		
		clientService.updateClient(client);
		return new ResponseEntity<Object>(genericResponse,HttpStatus.NO_CONTENT );
		
	}
	
	
	@RequestMapping(value="/{idclient}", method = RequestMethod.DELETE) 
	public ResponseEntity<Object> deleteClient(@PathVariable("idclient") int id) {
		
		
		clientService.deleteClient(id);
		return new ResponseEntity<Object>(genericResponse,HttpStatus.OK );
		
	}

}
