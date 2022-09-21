package com.CRUD.Java8.Example.DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CRUD.Java8.Example.Entity.ProductEntity;


@Repository
public class ProductImplementationDAO implements ProductInterfaceDAO
{
	private EntityManager entitymanager;
	@Autowired
	public ProductImplementationDAO(EntityManager value) {
		entitymanager = value;
	}

	@Override
	public List<String> findAll() {
		Session currentSession = entitymanager.unwrap(Session.class);
		Query<ProductEntity> result = currentSession.createQuery("from ProductEntity",ProductEntity.class);
		List<ProductEntity> productentity = result.getResultList();
		List<String> name = productentity.stream().map(u -> u.getName()).collect(Collectors.toList());
		
		//System.out.println(name);
		return name;
	}

	@Override
	public ProductEntity findById(int id) {
		
		ProductEntity value = entitymanager.find(ProductEntity.class, id);
		return value;
	
		//Session currentSession = entitymanager.unwrap(Session.class);
		//List<ProductEntity> result = currentSession.createQuery("select h from ProductEntity h WHERE h.id =:id", ProductEntity.class).list();
		//return currentSession.get(ProductEntity.class, id);
	}
	@Override
	public void save(ProductEntity productentity) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(productentity);
		//Query<ProductEntity> result = currentSession.createQuery("from ProductEntity",ProductEntity.class);
	//result
	}

	@Override
	public void deleteByid(int productid) {
		//Session currentSession = entitymanager.unwrap(Session.class);
		Query data = (Query) entitymanager.createQuery("delete from ProductEntity where id = :id");
		data.setParameter("id", productid).executeUpdate();
		
		
	}


	
	

}
