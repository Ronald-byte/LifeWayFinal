package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;

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
			int rpta = cS.insert(customer);
			if (rpta > 0)
			{
				model.addAttribute("mensaje", "Este cliente ya existe");
				return "customer/customer";
			}else
			{
				model.addAttribute("listCustomer", cS.list());
				model.addAttribute("mensaje", "Se registro correctamente");
				return "customer/listCustomer";
			}
			
		}
	}
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		try {
			model.addAttribute("listCustomer",cS.list());
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "customer/listCustomer";
	}
	
	@RequestMapping("/search")
	public String searchCustomers(Model model, @Validated Customer customer) throws ParseException 
	{
		List<Customer> listCustomer;
		model.addAttribute("customer", new Customer());
		listCustomer = cS.findNameCustumerFull(customer.getNameCustomer());
		if (listCustomer.isEmpty())
		{
			model.addAttribute("mensaje", "No se encontre este cliente");
		}
		model.addAttribute("listCustomer", listCustomer);
		return "customer/listCustomer";
	}
	
}
