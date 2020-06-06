package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Status;
import pe.edu.upc.serviceinterface.IStatusService;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private IStatusService sS;
	
	@GetMapping("/new")
	public String newStatus(Model model) {
		model.addAttribute("status",new Status());
		return "status/status";
	}
	
	@PostMapping("/save")
	public String saveStatus(@Validated Status status, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "status/status";
		}else {
			sS.insert(status);
			model.addAttribute("listStatus", sS.list());
			return "status/listStatus";
		}
	}
	
	@GetMapping("/list")
	public String listStatus(Model model) {
		try {
			model.addAttribute("listStatus",sS.list());
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "status/listStatus";
	}
	
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Status>objSta=sS.searchId(id);
		if(objSta==null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un error");
			return "redirect:/status/list";
		}else {
			model.addAttribute("status",objSta.get());
			return "status/status";
		}
	}
}
