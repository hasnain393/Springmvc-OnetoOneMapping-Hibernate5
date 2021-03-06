package com.lti.springmvc.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.springmvc.spring.dao.ProductDAO;
import com.lti.springmvc.spring.entity.Customer;
import com.lti.springmvc.spring.entity.Product;


@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	
	  @Autowired
	    private ProductDAO  productDAO;

	  @Override
	    @Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	  @Override
	    @Transactional
	public void saveProduct(Product theProduct) {
		productDAO.saveProduct(theProduct);
	}
	  
	  @Override
	    @Transactional
	    public Product getProduct(int theId) {
	        return productDAO.getProduct(theId);
	    }

	    @Override
	    @Transactional
	    public void deleteProduct(int theId) {
	    	productDAO.deleteProduct(theId);
	    }

}
