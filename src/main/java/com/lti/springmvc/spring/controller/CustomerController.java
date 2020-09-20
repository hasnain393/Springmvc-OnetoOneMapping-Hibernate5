package com.lti.springmvc.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.springmvc.spring.entity.Address;
import com.lti.springmvc.spring.entity.Customer;
import com.lti.springmvc.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
//@SessionAttributes("username")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// the below method will be invoked for following
	// urls:http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/list
	// &&
	// url:http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/
	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public String listCustomers(ModelMap theModel) {

		/*
		 * session code (to check if user loggedin) String username = (String)
		 * theModel.get("username");
		 * 
		 * System.out.println("///////list         " + username);
		 */
			
		/*
		 * Customer c =new Customer(); System.out.println("--"+c); Address a=new
		 * Address(); a.setCity("mumbai-london"); c.setAddress(a);
		 * System.out.println(c.getAddress().getCity());
		 * System.out.println("commented the code "); Customer
		 * customer=customerService.getCustomer(3); System.out.println(customer);
		 * System.out.println(customer.getAddress().getCity());
		 */		
		List<Customer> theCustomers = customerService.getCustomers();
			System.out.println(customerService.getTotalRecord());
			Long count = customerService.getTotalRecord();
			theModel.addAttribute("totalcount", count);
			theModel.addAttribute("customers", theCustomers);
			return "list-customers";

		
	}

	@GetMapping("/test")
	public void testingcall() {
		System.out.println("+++testing  buttn  in spring =_____)))))))))))(((((((((((((");
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "register-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

	@GetMapping("/count")
	public void getTotalRecord() {
		System.out.println("=============--------------inside   count");
		System.out.println(customerService.getTotalRecord());

	}

}