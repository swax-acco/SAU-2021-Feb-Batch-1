package com.au.session.ordermanager.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping(value = "/allProducts")
	public List<Product> fetchProducts(String id) {
		return jdbcTemplate.query("SELECT * FROM products", new RowMapper<Product>(){
			@Override
			public Product mapRow(ResultSet rs, int rownumber) throws SQLException {  
				Product p = new Product();  
				p.setId(rs.getInt(1));  
				p.setProduct_name(rs.getString(2));  
				p.setCategory_name(rs.getString(3));  
				p.setPrice(rs.getInt(4)); 
				return p;  
			}  
		});
	}
}

