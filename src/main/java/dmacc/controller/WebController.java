package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Phone;
import dmacc.repository.PhoneRepository;

@Controller
public class WebController {
	@Autowired
	PhoneRepository repo;
	
	@GetMapping({ "/", "/viewAll"})
	public String viewAllPhones(Model model) {
		if(repo.findAll().isEmpty()) { 
			return addNewPhone(model);
		}
		model.addAttribute("phones", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputPhone")
    public String addNewPhone(Model model) {
        Phone p = new Phone();
        model.addAttribute("newPhone", p);
        return "input";
	}
	
	@PostMapping("/inputPhone")
    public String addNewPhone(@ModelAttribute Phone p, Model model) {
         repo.save(p);
         return viewAllPhones(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePhone(@PathVariable("id") long id,
		Model model) {
		Phone p = repo.findById(id).orElse(null);
		model.addAttribute("newPhone", p);
		return "input"; 
	}
	
	@PostMapping("/update/{id}")
		public String reviseContact(Phone p, Model model) {
		repo.save(p);
		return viewAllPhones(model); 
	}
	
	@GetMapping("/delete/{id}")
		public String deletePhone(@PathVariable("id") long id, Model model) {
		Phone p = repo.findById(id).orElse(null); 
		repo.delete(p);
		return viewAllPhones(model);
	}
	
}

	
