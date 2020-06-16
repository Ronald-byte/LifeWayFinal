package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Bike;
import pe.edu.upc.serviceinterface.IBikeService;
import pe.edu.upc.serviceinterface.IBrandService;
import pe.edu.upc.serviceinterface.IStatusService;

@Controller
@RequestMapping("/bikes")
@Secured("ROLE_ADMIN")
public class BikeController {

	@Autowired
	private IBikeService bS;
	@Autowired
	private IBrandService brS;
	@Autowired
	private IStatusService sS;
	
	

	@GetMapping("/new")
	public String newBike(Model model) {

		model.addAttribute("listBrands", brS.list());
		model.addAttribute("listStatus", sS.list());
		model.addAttribute("bike", new Bike());
		return "bike/bike";	
	}
	
	@PostMapping("/save")
	public String saveBike(@Validated Bike bike, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("listBrands", brS.list());
			model.addAttribute("listStatus", sS.list());
			return "bike/bike";
		}else {
			bS.insert(bike);
			model.addAttribute("listBike", bS.list());
			return "bike/listBike";
		}
		
	}
	
	@GetMapping("/list")
	public String listBike(Model model) {
		try {
			model.addAttribute("listBike", bS.list());
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "bike/listBike";
		
		
	}
	
}
