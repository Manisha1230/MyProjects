package com.CRUD.Java8.Example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.Java8.Example.DAO.ProductInterfaceDAO;
import com.CRUD.Java8.Example.Entity.ProductEntity;
@Service
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	private ProductInterfaceDAO productInterfaceDAO;

	@Override
	@Transactional
	public List<String> findAll() {

		return productInterfaceDAO.findAll();
	}

	@Override
	@Transactional
	public ProductEntity findById(int id) {

		return productInterfaceDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(ProductEntity productentity) {
		productInterfaceDAO.save(productentity);

	}

	@Override
	@Transactional
	public void deleteByid(int id) {

		 productInterfaceDAO.deleteByid(id);
	}

	
}
