package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Bike;
import pe.edu.upc.serviceinterface.IBikeService;

@Controller
@RequestMapping("/bikes")
public class BikeController {

	@Autowired
	private IBikeService bS;
	
	@GetMapping("/new")
	public String newBike(Model model) {
		model.addAttribute("bike", new Bike());
		return "bike/bike";	
	}
	
	@PostMapping("/save")
	public String saveBike(@Validated Bike bike, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "bike/bike";
		}else {
			bS.insert(bike);
			model.addAttribute("listBikes", bS.list());
			return "bike/listBikes";
		}
		
	}
	
	@GetMapping("/list")
	public String listBikes(Model model) {
		try {
			model.addAttribute("listBikes", bS.list());
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "bike/listBikes";
		
		
	}
	
}
