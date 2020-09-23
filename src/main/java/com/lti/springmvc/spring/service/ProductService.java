package com.lti.springmvc.spring.service;

import java.util.List;

import com.lti.springmvc.spring.entity.Product;

public interface ProductService {
	
	public List < Product > getProducts();

    public void saveProduct(Product theProduct);
}
