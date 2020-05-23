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
import pe.edu.upc.serviceinterfce.ITypeEmployeeService;

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
	public String saveTypeEmployee(@Validated TypeEmployee typeEmployee, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
			return "typeEmployee/typeEmployee";
		} else {
			teS.insert(typeEmployee);
			model.addAttribute("listTypeEmployees", teS.list());
			return "typeEmployee/listTypeEmployee";
		}
	}

	@GetMapping("/list")
	public String listTypeEmployees(Model model) {
		try {
			model.addAttribute("listTypeEmployees", teS.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "typeEmployee/listTypeEmployees";
	}
}
