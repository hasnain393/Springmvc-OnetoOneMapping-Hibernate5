package com.lti.springmvc.spring.service;


import java.util.List;

import com.lti.springmvc.spring.entity.Customer;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    public List <Customer> getByAscOrder();
    
    public List<Customer> startsWith(String keyword);
    
    public  Long getTotalRecord();
    
    //test pagination
    public  List<Customer> readEntireDataByPagination(int pgNumber,int pgSize);
    

}
