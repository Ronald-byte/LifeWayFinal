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
import pe.edu.upc.serviceinterface.IRentalTicketService;

@Controller
@RequestMapping("/rentalTickets")
public class RentalTicketController {

    @Autowired
	private IRentalTicketService rtS;
	
	@GetMapping("/new")
	public String newRentalTicket(Model model) {
		model.addAttribute("rentalTicket", new RentalTicket());
		return "rentalTicket/rentalTicket";	
	}
	
	@PostMapping("/save")
	public String saveRentalTicket(@Validated RentalTicket rentalTicket, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			return "rentalTicket/rentalTicket";
		}else {
			rtS.insert(rentalTicket);
			model.addAttribute("listRentalTickets", rtS.list());
			return "rentalTicket/listRentalTickets";
		}
		
	}
	
	@GetMapping("/list")
	public String listRentalTickets(Model model) {
		try {
			model.addAttribute("listRentalTickets", rtS.list());
		}catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rentalTicket/listRentalTickets";
		
		
	}

    
}