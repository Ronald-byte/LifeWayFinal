package pe.edu.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wellcome")
public class WelcomeController {

	@RequestMapping("/well")
	public String Wellcome()
	{
		return "welcome/listWelcome";
	}
}
