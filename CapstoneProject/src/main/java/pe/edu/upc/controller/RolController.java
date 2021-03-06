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

import pe.edu.upc.entity.Role;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IUserService;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private IRolService rS;
	@Autowired
	private IUserService uS;

	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listUsers", uS.list());
		return "rol/role";
	}
	@PostMapping("/save")
	public String saveRole(@Validated Role role, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listRoles",rS.list());
			return "rol/role";
		} else {
			rS.insert(role);
			model.addAttribute("listRoles",rS.list());
			return "rol/listRoles";
		}
	}
	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("listRoles", rS.list());
			model.addAttribute("role",new Role());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRoles";

	}

}
