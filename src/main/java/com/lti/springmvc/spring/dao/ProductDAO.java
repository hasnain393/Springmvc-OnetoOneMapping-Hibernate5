package com.lti.springmvc.spring.dao;

import java.util.List;

import com.lti.springmvc.spring.entity.Product;


public interface ProductDAO {
	
	public List < Product > getProducts();

    public void saveProduct(Product theProduct);

}
