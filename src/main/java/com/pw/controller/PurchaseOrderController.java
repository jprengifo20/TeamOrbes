package com.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw.model.entity.Supplier;
import com.pw.model.entity.PurchaseOrder;
import com.pw.service.SupplierService;
import com.pw.service.PurchaseOrderService;

@Controller
@RequestMapping("/purchaseorders")
public class PurchaseOrderController {

	
	@Autowired
	private PurchaseOrderService purchaseorderService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping
    public String showAllPurchaseOrders(Model model) {
        model.addAttribute("purchaseorders", purchaseorderService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
        return "purchaseorders/list";
    }

	
	@GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("purchaseorder", new PurchaseOrder());
        List<Supplier> suppliers = supplierService.getAll();
        model.addAttribute("suppliers", suppliers);
        return "purchaseorders/new";
    }
	
	
	
	@PostMapping("/save")
    public String saveNewPurchaseOrder(PurchaseOrder purchaseorder) {
        long id = purchaseorderService.create(purchaseorder);
        return "redirect:/purchaseorders";
    }

	
	@GetMapping("/edit/{id}")
    public String editPurchaseOrderForm(@PathVariable("id") long id, Model model) {
		PurchaseOrder purchaseorder = purchaseorderService.getOneById(id);
        List<Supplier> suppliers = supplierService.getAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("purchaseorder", purchaseorder);
        return "purchaseorders/edit";
    }

	
	@PostMapping("/update/{id}")
    public String updatePurchaseOrder(@PathVariable("id") long id, PurchaseOrder purchaseorder) {
		purchaseorderService.update(id, purchaseorder);
        return "redirect:/purchaseorders";    
    }

}
