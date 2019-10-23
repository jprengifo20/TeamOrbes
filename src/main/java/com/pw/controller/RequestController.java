package com.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw.model.entity.Request;
import com.pw.service.RequestService;

@Controller
@RequestMapping("/requests")
public class RequestController {

	@Autowired
    private RequestService requestService;

	@GetMapping
    public String showAllRequests(Model model) {
        model.addAttribute("requests", requestService.getAll());
        return "requests/list";
    }
	
	
	@GetMapping("/new")
    public String newReqForm(Model model) {
        model.addAttribute("request", new Request());
        return "requests/new";
    }

	
	@PostMapping("/save")
    public String saveNewRequest(Request request) {
        long id= requestService.create(request);
        return "redirect:/requests";
    }
	
	
	@GetMapping("/edit/{id}")
    public String editRquestForm(@PathVariable("id") long id, Model model) {
		Request request = requestService.getOneById(id);
        System.out.println(request.getArea());
        System.out.println(request.getProduct());

        
        model.addAttribute("request", request);
        return "requests/edit";
    }
	
	
	@PostMapping("/update/{id}")
    public String updateRequest(@PathVariable("id") long id, Request request) {
		requestService.update(id, request);
        return "redirect:/requests";    
    }
	
	@GetMapping("/delete/{id}")
	public String deleteSupplierForm(@PathVariable("id")long id, Model model)
	{
		Request request = requestService.getOneById(id);
		System.out.println(request.getArea());
		model.addAttribute("request", request);
		return "requests/delete";		
	}
	
	@PostMapping("drop/{id}")
	public String deleteRequest(@PathVariable("id")long id, Request request)
	{
		requestService.delete(id);
		return "redirect:/requests";
	}
	
	/*@GetMapping
	public String searchRequest()
	{
		
	}*/
	
	
}
