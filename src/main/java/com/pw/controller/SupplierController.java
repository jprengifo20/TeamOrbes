package com.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw.model.entity.Supplier;
import com.pw.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping
	public String showAllSuppliers(Model model)
	{
		model.addAttribute("suppliers", supplierService.getAll());
		return "suppliers/list";
	}
	
	@GetMapping("/new")
	public String newBookForm(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		return "suppliers/new";
	}
	
	@PostMapping("/save")
	public String saveNewSupplier(Supplier supplier)
	{
		long id = supplierService.create(supplier);
		return "redirect:/suppliers";
	}
	
	@GetMapping("/edit/{id}")
	public String editSupplierForm(@PathVariable("id")long id, Model model)
	{
		Supplier supplier = supplierService.getOneById(id);
		System.out.println(supplier.getEnterprise());
		model.addAttribute("supplier", supplier);
		return "suppliers/edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateSupplier(@PathVariable("id")long id, Supplier supplier)
	{
		supplierService.update(id, supplier);
		return "redirect:/suppliers";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSupplierForm(@PathVariable("id")long id, Model model)
	{
		Supplier supplier = supplierService.getOneById(id);
		System.out.println(supplier.getEnterprise());
		model.addAttribute("supplier", supplier);
		return "suppliers/delete";		
	}
	
	@PostMapping("drop/{id}")
	public String deleteSupplier(@PathVariable("id")long id, Supplier supplier)
	{
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
}
