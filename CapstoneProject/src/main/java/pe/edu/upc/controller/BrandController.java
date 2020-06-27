package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Optional;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.serviceinterface.IBrandService;

@Controller
@RequestMapping("/brands")
@Secured("ROLE_ADMIN")
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
			int rpta = bS.insert(brand);
			if (rpta > 0) {
			model.addAttribute("mensaje", "Ya existe la Marca");
			return "brand/brand";
			}else {
			model.addAttribute("mensaje", "Se guardó correctamente");
			model.addAttribute("listBrand", bS.list());
			return "brand/listBrand";
			}
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
	
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Brand>objBra=bS.searchId(id);
		if(objBra==null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un error");
			return "redirect:/brands/list";
		}else {
			model.addAttribute("brand",objBra.get());
			return "brand/brand";
		}
	}
	
	@RequestMapping("/reporte1")
	public String brandTop(Map<String, Object> model) {
		model.put("listBrandTop", bS.brandtop());
		return "redirect:reports/brandTop";
}
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
}
