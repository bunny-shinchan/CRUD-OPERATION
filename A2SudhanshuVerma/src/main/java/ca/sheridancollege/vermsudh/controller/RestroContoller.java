package ca.sheridancollege.vermsudh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.vermsudh.beans.Restaurant;
import ca.sheridancollege.vermsudh.database.DatabaseAccess;

@Controller
public class RestroContoller {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("restro", new Restaurant());
		return "index";

	}

	@PostMapping("/insertRestroList") 
	public String insertRestroList(Model model, @RequestParam Long id, 
			@RequestParam String name,  @RequestParam String review, @RequestParam String reviewDate, 
			             @RequestParam String reviewTime) { 
				da.insertRestroList(id, name, review, reviewDate, reviewTime); 
			    model.addAttribute("restro", new Restaurant());
			    model.addAttribute("restroList", da.getRestaurantLists());
		        return "index";
	} 
	@GetMapping("/deleteRestroList/{id}")
	public String deleteRestroList(Model model, @PathVariable Long id) {
		da.deleteRestroList(id);
		model.addAttribute("restro", new Restaurant());
		model.addAttribute("restroList", da.getRestaurantLists());
		return "index";

	}
	@GetMapping("/editRestaurantList/{id}")
	public String editStudent(Model model, @PathVariable Long id ) {
		
		Restaurant restro = da.getRestaurantsById(id).get(0);
		model.addAttribute("restro", restro);
		da.deleteRestroList(id);
		model.addAttribute("restroList", da.getRestaurantLists());
		
		return "index";
		
	}

	
	
}
