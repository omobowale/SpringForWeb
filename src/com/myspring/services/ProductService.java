package com.myspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dao.Product;
import com.myspring.dao.ProductsDAO;

@Service
public class ProductService {
	
	@Autowired
	ProductsDAO productsdao;
	
	public List<Product> getProductsUsingService(){
		return productsdao.getProducts();
	}
	
	public Product getProductUsingService(int id) {
		return productsdao.getProduct(id);
	}
	
	public boolean insertProductsUsingService(Product product) {
		return productsdao.insertProduct(product);
	}
	
}
