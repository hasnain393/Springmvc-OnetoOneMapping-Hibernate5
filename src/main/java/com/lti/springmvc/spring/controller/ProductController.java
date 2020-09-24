package com.lti.springmvc.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.springmvc.spring.entity.Customer;
import com.lti.springmvc.spring.entity.Product;
import com.lti.springmvc.spring.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
    HttpServletRequest httpServletRequest; 
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/showaddproductpage")
	public String showAddProductPage(Model theModel) {
		Product theProduct = new Product();
		theModel.addAttribute("product", theProduct);
		return "add-product";
	}
	
	@PostMapping("/addproduct")
	public String AddProduct(@ModelAttribute("product") Product theProduct,Model theModel) {
		System.out.println("inside add product method");
		System.out.println("============");
		System.out.println(theProduct.getFile().getOriginalFilename());
		
		System.out.println("init object"+theProduct);
		String f_name= theProduct.getFile().getOriginalFilename();
		//String f_path="C:/SingleFileUpload\\"+f_name;
		
				  
		//System.out.println(f_path);
		
		//customerService.saveCustomer(theCustomer);
		theProduct.setImg_path(f_name);
		
		System.out.println("after setting"+theProduct.getImg_path());
		System.out.println("updated object"+theProduct);
		productService.saveProduct(theProduct);
		System.out.println("inserted the  value into  db");
		MultipartFile multipartfile= theProduct.getFile();
		if(multipartfile !=null || !multipartfile.isEmpty()) {
			
			System.out.println("SERVLET "+servletContext.getRealPath("/"));
			
			  String CONTAINER_ROOT = httpServletRequest.getSession().getServletContext().getRealPath("/");
			  System.out.println("containerhttp"+CONTAINER_ROOT);
			  String fileName = servletContext.getRealPath("/") + "resources\\images\\" + f_name;  
			  
		try {
            multipartfile.transferTo(new File(fileName));
            
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		} 
			theModel.addAttribute("msg", "File uploaded successfully.");
		         theModel.addAttribute("product", theProduct);
		         
		    

			
		
		
	//	return "redirect:/product/showproduct";
		return "show-products";
		
	}
	
	@GetMapping("/showproduct")
	public String showProducts(Model theModel) {
		
		return "show-products";
	}


	@RequestMapping("showAllProducts")
	public String showAllProductsPage(Model theModel) {
		
		List<Product> products=productService.getProducts();
		theModel.addAttribute("products", products);
		return "show-all-products";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int prodId) {
		System.out.println(prodId);
		productService.deleteProduct(prodId);
		System.out.println("deleeting the selected element fro the database");
		return "redirect:/product/showAllProducts";
	}
	
	@RequestMapping("/update")
	public String updateProduct(@RequestParam("productId") int prodId,Model theModel) {
		System.out.println(prodId);
		Product product=productService.getProduct(prodId);
		System.out.println(" selected element fro the database");
		System.out.println(product);
		theModel.addAttribute("product", product);
		return "update-product";
	}
	
	@PostMapping("/saveProduct")
	public String saveCustomer(@ModelAttribute("product") Product theProduct) {
		System.out.println(theProduct);
		productService.saveProduct(theProduct);
		return "redirect:/product/showAllProducts";
	}
}
