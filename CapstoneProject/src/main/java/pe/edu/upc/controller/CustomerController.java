package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.serviceinterface.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomerService cS;
	
	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer/customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@Validated Customer customer, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "customer/customer";
		}else {
			cS.insert(customer);
			model.addAttribute("listCustomer", cS.list());
			return "customer/listCustomer";
		}
	}
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		try {
			model.addAttribute("listCustomers",cS.list());
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "customer/listCustomer";
	}
}
