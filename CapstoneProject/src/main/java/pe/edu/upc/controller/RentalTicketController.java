package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
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

import pe.edu.upc.entity.RentalTicket;
import pe.edu.upc.serviceinterface.IBikeService;
import pe.edu.upc.serviceinterface.ICustomerService;
import pe.edu.upc.serviceinterface.IEmployeeService;
import pe.edu.upc.serviceinterface.IRentalTicketService;

@Controller
@RequestMapping("/rentalTickets")
@Secured({"ROLE_ADMIN","ROLE_USER"})
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
		model.addAttribute("listCustomers", cS.list());
		model.addAttribute("listBikes", bS.list());
		model.addAttribute("listEmployees", eS.list());
		model.addAttribute("rentalTicket", new RentalTicket());
		return "rentalTicket/rentalTicket";	
	}
	
	@PostMapping("/save")
	public String saveRentalTicket(@Validated RentalTicket rentalTicket, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("listCustomers", cS.list());
			model.addAttribute("listBikes", bS.list());
			model.addAttribute("listEmployees", eS.list());
			return "rentalTicket/rentalTicket";
		}else {
			if (rentalTicket.getIdRentalTicket()>0){				
				rtS.update(rentalTicket);
				model.addAttribute("listRentalTicket", rtS.list());
				model.addAttribute("mensaje", "Se actualizo correctamente");
				return "redirect:/rentalTickets/list";
			} else {			
			rtS.insert(rentalTicket);
			model.addAttribute("mensaje","Se registró ticket de alquiler correctamente");
			model.addAttribute("listRentalTicket", rtS.list());
			return "redirect:/rentalTickets/list";
			}
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

	
	
	@RequestMapping("/delete/{id}")
	public String deleteRentalTicket(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				rtS.delete(id);
			}
				model.addAttribute("listRentalTicket", rtS.list());
				model.addAttribute("mensaje", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("rentalTicket", new RentalTicket());
			System.out.println(e.getMessage());
			model.addAttribute("rentalTicketss", rtS.list());
		}
		return "rentalTicket/listRentalTicket";

	}

	
	@RequestMapping("/search")
	public String searchProducts(Model model, @Validated RentalTicket rentalTicket) throws ParseException {
		List<RentalTicket> listRentalTickets;
		model.addAttribute("rentalTicket", new RentalTicket());
		listRentalTickets = rtS.search(rentalTicket.getCustomer().getNameCustomer());
		if (listRentalTickets.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listRentalTickets", listRentalTickets);
		return "rentalTicket/listRentalTicket";

	}
	
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<RentalTicket> objAr = rtS.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/rentalTickets/list";
		} else {
			model.addAttribute("listCustomers", cS.list());
			model.addAttribute("listBikes", bS.list());
			model.addAttribute("listEmployees", eS.list());
			model.addAttribute("rentalTicket", objAr.get());
			return "rentalTicket/rentalTicketUpdate";	
		}
	}
	
	
	
    
}