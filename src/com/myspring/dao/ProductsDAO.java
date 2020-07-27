package com.myspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductsDAO {

	NamedParameterJdbcTemplate jdbc;
	
	public ProductsDAO() {
		
		System.out.println("Loaded");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Product> getProducts(){
		
		return jdbc.query("select * from products", new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPicture(rs.getString("picture"));
				
				return product;
				
				
			}
			
		});
		
		
		
	}
	

	public Product getProduct(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("select * from products where id= :id", params, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPicture(rs.getString("picture"));
				
				return product;
				
				
			}
			
		});
		
		
		
	}

	public boolean insertProduct(Product product) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", product.getName());
		params.addValue("price", product.getPrice());
		params.addValue("quantity", product.getQuantity());
		params.addValue("picture", product.getPicture());
		
		return jdbc.update("insert into products (name, price, quantity, picture) values (:name, :price, :quantity, :picture)", params) == 1;
	
	}

	public boolean updateProduct(Product product) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(product);
		
		return jdbc.update("update products set name=:name, price=:price, quantity=:quantity, picture=:picture where id =:id", params) == 1;
		
	}
	
}


