package com.interview.util;

import org.springframework.stereotype.Component;

import com.interview.model.Client;

@Component
public class Utils {
	
	public boolean hasValidIdClient(Client client) {
		return (client.getId() != 0) ? true : false;
	}

}
