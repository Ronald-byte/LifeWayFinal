package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.serviceinterfce.IBrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService bS;
	
	@GetMapping("/new")
	public String newBrand(Model model) {
		model.addAttribute("brand",new Brand());
		return "brand/brand";
	}
	
	@PostMapping("/save")
	public String saveBrand(@Validated Brand brand, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "brand/brand";
		}else {
			bS.insert(brand);
			model.addAttribute("listBrand", bS.list());
			return "brand/listBrand";
		}
	}
	
	@GetMapping("/list")
	public String listBrand(Model model) {
		try {
			model.addAttribute("listBrand",bS.list());
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "brand/listBrand";
	}
}
