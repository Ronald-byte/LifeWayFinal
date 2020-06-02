package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.RentalTicket;
import pe.edu.upc.serviceinterface.IBikeService;
import pe.edu.upc.serviceinterface.ICustomerService;
import pe.edu.upc.serviceinterface.IEmployeeService;
import pe.edu.upc.serviceinterface.IRentalTicketService;

@Controller
@RequestMapping("/rentalTickets")
public class RentalTicketController {

	@Autowired
	private IRentalTicketService rtS;
	@Autowired
	private ICustomerService cS;
	@Autowired
	private IBikeService bS;
	@Autowired
	private IEmployeeService eS;
	
	@GetMapping("/new")
	public String newRentalTicket(Model model) {	
		model.addAttribute("listCustomer", cS.list());
		model.addAttribute("listBike", bS.list());
		model.addAttribute("listEmployee", eS.list());
		model.addAttribute("rentalTickets", new RentalTicket());
		return "rentalTicket/rentalTicket";	
	}
	
	@PostMapping("/save")
	public String saveRentalTicket(@Validated RentalTicket rentalTicket, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("listCustomer", cS.list());
			model.addAttribute("listBike", bS.list());
			model.addAttribute("listEmployee", eS.list());
			return "rentalTicket/rentalTicket";
		}else {
			rtS.insert(rentalTicket);
			model.addAttribute("listRentalTicket", rtS.list());
			return "rentalTicket/listRentalTicket";
		}
		
	}
	
	@GetMapping("/list")
	public String listRentalTicket(Model model) {
		try {
			model.addAttribute("listRentalTicket", rtS.list());
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rentalTicket/listRentalTicket";
		
		
	}

    
}