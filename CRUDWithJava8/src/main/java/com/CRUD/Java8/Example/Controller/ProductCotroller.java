package com.CRUD.Java8.Example.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Java8.Example.Entity.ProductEntity;
import com.CRUD.Java8.Example.service.ServiceInterface;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/product")
public class ProductCotroller 
{
	
	private ServiceInterface serviceInterface;
	@Autowired
	public ProductCotroller(ServiceInterface theserviceInterface) {
		serviceInterface = theserviceInterface;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/products")
	public List<String> findAll(){
		
		return  serviceInterface.findAll();
		
	}
	@GetMapping("/products/{id}")
	public ProductEntity getProductEntity(@PathVariable("id") int productid) {
		ProductEntity xyz = serviceInterface.findById(productid);
		return xyz;
	}
	@PostMapping("/products")
	public String addProduct(@RequestBody ProductEntity productEntity) {
		serviceInterface.save(productEntity);
		return "New Product is added";
}
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") int id ,@RequestBody ProductEntity productEntity) {
		serviceInterface.save(productEntity);
		return "Old id is updated";
		
	}
	@DeleteMapping("/products/{id}")
	public  String deleteBy(@PathVariable("id") int productid) throws Exception {
		ProductEntity temp = serviceInterface.findById(productid);
		if(temp==null) {
			return "Product not found";
		}
		serviceInterface.deleteByid(productid);
		return "Product deleted successfully";
		
		
	}
	
	

}
