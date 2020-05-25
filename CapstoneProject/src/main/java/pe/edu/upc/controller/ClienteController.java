package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceinterfce.IClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private IClienteService cS;
	
	@GetMapping("/new")
	public String newCliente(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "cliente/cliente";
	}
	
	@PostMapping("/save")
	public String saveCliente(@Validated Cliente cliente, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "cliente/cliente";
		}else {
			cS.insert(cliente);
			model.addAttribute("listStatus", cS.list());
			return "cliente/listCliente";
		}
	}
	
	@GetMapping("/list")
	public String listCliente(Model model) {
		try {
			model.addAttribute("listCliente",cS.list());
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "cliente/listCliente";
	}
}
