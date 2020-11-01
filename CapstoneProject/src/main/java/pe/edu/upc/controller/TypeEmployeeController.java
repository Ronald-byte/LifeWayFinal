package pe.edu.upc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.sun.el.parser.ParseException;

import pe.edu.upc.entity.TypeEmployee;
import pe.edu.upc.serviceinterface.ITypeEmployeeService;

@Controller
@RequestMapping("/typeEmployees")
@Secured("ROLE_ADMIN")
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
			int rpta = teS.insert(typeEmployee);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe el Tipo de empleado");
				return "typeEmployee/typeEmployee";
			} else {
				model.addAttribute("mensaje", "Seguardo correctamente");
				model.addAttribute("listTypeEmployee", teS.list());
				return "typeEmployee/listTypeEmployee";
			}
		}
	}

	@GetMapping("/list")
	public String listTypeEmployees(Model model) {
		try {
			model.addAttribute("listTypeEmployee", teS.list());
			model.addAttribute("typeEmployee", new TypeEmployee());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "typeEmployee/listTypeEmployee";
	}

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<TypeEmployee> objTyp = teS.searchId(id);
		if (objTyp == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error al actualizar");
			return "redirect:/typeEmployees/list";
		} else {
			model.addAttribute("typeEmployee", objTyp.get());
			return "typeEmployee/typeEmployee";
		}
	}

	@RequestMapping("/search")
	public String searchTypeEmployees(Model model, @Validated TypeEmployee typeEmployee) throws ParseException {
		List<TypeEmployee> listTypeEmployee;
		listTypeEmployee = teS.findByNameTypeEmployeeFull(typeEmployee.getNameTypeEmployee());
		if (listTypeEmployee.isEmpty()) {
			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listTypeEmployee", listTypeEmployee);
		return "typeEmployee/listTypeEmployee";

	}

	@RequestMapping("/reporte2")
	public String typeTop(Map<String, Object> model) {
		model.put("listTypeEmployeeTop", teS.typetop());
		return "reports/typeTop";
	}

}
