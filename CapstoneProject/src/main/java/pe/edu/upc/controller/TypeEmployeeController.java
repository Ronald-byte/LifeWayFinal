package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.TypeEmployee;
import pe.edu.upc.serviceinterface.ITypeEmployeeService;

@Controller
@RequestMapping("/typeEmployees")
public class TypeEmployeeController {

	@Autowired
	private ITypeEmployeeService teS;

	@GetMapping("/new")
	public String newTypeEmployee(Model model) {
		model.addAttribute("typeEmployee", new TypeEmployee());
		return "typeEmployee/typeEmployee";
	}

	@PostMapping("/save")
	public String saveTypeEmployee(@Validated TypeEmployee typeEmployee, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "typeEmployee/typeEmployee";
		} else {
			int rpta=teS.insert(typeEmployee);
			if (rpta>0) {
				model.addAttribute("mensaje","Ya existe el Tipo de empleado");
				return "typeEmployee/typeEmployee";
			} else {
				model.addAttribute("listTypeEmployee",teS.list());
				return "typeEmployee/listTypeEmployee";
			}
		}
	}

	@GetMapping("/list")
	public String listTypeEmployees(Model model) {
		try {
			model.addAttribute("listTypeEmployee", teS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "typeEmployee/listTypeEmployee";
	}
}
