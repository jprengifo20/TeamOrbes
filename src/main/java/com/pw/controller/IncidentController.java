package com.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw.model.entity.Category;
import com.pw.model.entity.Incident;
import com.pw.service.CategoryService;
import com.pw.service.IncidentService;

@Controller
@RequestMapping("/incidents")
public class IncidentController {

	
	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
    public String showAllIncidents(Model model) {
        model.addAttribute("incidents", incidentService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "incidents/list";
    }

	
	@GetMapping("/new")
    public String newIncidentForm(Model model) {
        model.addAttribute("incident", new Incident());
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "incidents/new";
    }
	
	
	
	@PostMapping("/save")
    public String saveNewIncident(Incident incident) {
        long id = incidentService.create(incident);
        return "redirect:/incidents";
    }

	
	@GetMapping("/edit/{id}")
    public String editIncidentForm(@PathVariable("id") long id, Model model) {
        Incident incident = incidentService.getOneById(id);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("incident", incident);
        return "incidents/edit";
    }

	
	@PostMapping("/update/{id}")
    public String updateIncident(@PathVariable("id") long id, Incident incident) {
        incidentService.update(id, incident);
        return "redirect:/incidents";    
    }

}
