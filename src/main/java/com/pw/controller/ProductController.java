package com.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw.model.entity.Category;
import com.pw.model.entity.Product;
import com.pw.service.CategoryService;
import com.pw.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductService productService;

	@GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products/list";
    }
	
	
	@GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/new";
    }

	
	@PostMapping("/save")
    public String saveNewProduct(Product product) {
        long id = productService.create(product);
        return "redirect:/products";
    }
	
	
	@GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") long id, Model model) {
        Product product = productService.getOneById(id);
        System.out.println(product.getName());
        model.addAttribute("product", product);
        return "products/edit";
    }
	
	
	@PostMapping("/update/{id}")
    public String updateProducts(@PathVariable("id") long id, Product product) {
        productService.update(id, product);
        return "redirect:/products";    
    }
}

