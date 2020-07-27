package com.myspring.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myspring.dao.Product;
import com.myspring.services.ProductService;

@Controller
public class PagesController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping("/")
	public String showIndexPage(Model model) {
		List<Product> products = productservice.getProductsUsingService();
		System.out.println(products);
		model.addAttribute("products", products);
		
		return "index";  //index is the logical name of our view i.e index.jsp
	}
	
	@RequestMapping("/home")
	public String showHomePage(Model model) {
		model.addAttribute("secondname", "<script>alert('Adesmart')</script>");
		return "home";
	}
	
	@RequestMapping("/products")
	public String showProducts(Model model) {
		
		model.addAttribute("productname", "Nokia");
		return "products";
		
	}
	
	@RequestMapping("/addinv")
	public String addInv() {
		return "addinv";
	}
	
	@RequestMapping("/check")
	public String check(Model model) {
		
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + "me.jpg");
				String newserverFile = serverFile.toString().replace("\\", "/");
				System.out.println("ServerFile : " + newserverFile);
				model.addAttribute("img", newserverFile);
		

		
		
		return "check";
	}
	
	

	
	@RequestMapping("/test")
	public String testPage() {
		
		return "test";
	}
	
	
	@RequestMapping(value="/showsomething", method=RequestMethod.GET)
	public @ResponseBody String show() {
		return productservice.getProductsUsingService().toString();
	}
	
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public String addProduct(Model model, HttpServletRequest request, Product product, @RequestParam("product_image") MultipartFile file) {
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(request.getContextPath()
						+ File.separator + "WebContent/Resources/images/"  + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
				
				product.setPicture(file.getOriginalFilename());
				System.out.println(request.getContextPath());
				System.out.println("You successfully uploaded file=" + "myfile");
			} catch (Exception e) {
				System.out.println("You failed to upload " + file + " => " + e.getMessage());
			}
		} else {
			System.err.println("You failed to upload " + "myfile"
					+ " because the file was empty.");
		}
		

		
		System.out.println(product);
		
		System.out.println(productservice.insertProductsUsingService(product));
		
		return "products";
		
	}
	
}
