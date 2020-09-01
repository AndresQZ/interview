package com.interview.model.dao;

import java.util.List;

import com.interview.rest.exceptions.UserNotFound;

public interface Dao<T> {
	
	 void save(T t);
	  T load(int id);
	  void delete(int id);
	  void update(T t) throws UserNotFound;
	  List<T> loadAll();

}
