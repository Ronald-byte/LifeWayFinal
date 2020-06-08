package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Employee;
import pe.edu.upc.serviceinterface.IEmployeeService;
import pe.edu.upc.serviceinterface.ITypeEmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService eS;
	
	@Autowired
	private ITypeEmployeeService teS;

	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("listTypeEmployees", teS.list());
		model.addAttribute("employee", new Employee());
		return "employee/employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@Validated Employee employee, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listTypeEmployees",teS.list());
			return "employee/employee";
		} else {
			int rpta = eS.insert(employee);
			if (rpta > 0) {
				model.addAttribute("listTypeEmployees",teS.list());
				model.addAttribute("mensaje", "Ya existe el empleado");
				return "employee/employee";
			} else {
				eS.insert(employee);
				model.addAttribute("mensaje", "Se guardo correctamente");
				model.addAttribute("listTypeEmployees",teS.list());
				return "redirect:/employees/list";
			}
		}

	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		try {
			model.addAttribute("listEmployee", eS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "employee/listEmployee";

	}

}