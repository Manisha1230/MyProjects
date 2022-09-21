package com.CRUD.Java8.Example.service;

import java.util.List;

import com.CRUD.Java8.Example.Entity.ProductEntity;

public interface ServiceInterface {
   
	public List<String> findAll();
	
	public ProductEntity findById(int id);
	
	public void save(ProductEntity productentity);
	
	public void deleteByid(int id);
	
	
	
}
