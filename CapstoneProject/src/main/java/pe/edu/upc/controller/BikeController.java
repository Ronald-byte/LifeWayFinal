package pe.edu.upc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.entity.Bike;
import pe.edu.upc.serviceinterface.IBikeService;
import pe.edu.upc.serviceinterface.IBrandService;
import pe.edu.upc.serviceinterface.IStatusService;
import pe.edu.upc.serviceinterface.IUploadFileService;

@Controller
@RequestMapping("/bikes")
@Secured({"ROLE_ADMIN"})
public class BikeController {

	@Autowired
	private IBikeService bS;
	@Autowired
	private IBrandService brS;
	@Autowired
	private IStatusService sS;
	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping("/new")
	public String newBike(Model model) {

		model.addAttribute("listBrands", brS.list());
		model.addAttribute("listStatus", sS.list());
		model.addAttribute("bike", new Bike());
		return "bike/bike";
	}

	@PostMapping("/save")
	public String saveBike(@Validated Bike bike, BindingResult result, Model model,
			@RequestParam("file") MultipartFile photo, RedirectAttributes flash, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listBrands", brS.list());
			model.addAttribute("listStatus", sS.list());

			return "bike/bike";
		} else {
			if (!photo.isEmpty()) {

				if (bike.getIdBike() > 0 && bike.getPhotoBike() != null
				 && bike.getPhotoBike().length() > 0) {

					uploadFileService.delete(bike.getPhotoBike());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(photo);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				bike.setPhotoBike(uniqueFilename);
			}

			if (bike.getIdBike() > 0) {

				// posible ubicacion

				bS.update(bike);
				model.addAttribute("listBike", bS.list());
				model.addAttribute("mensaje", "Se actualizo correctamente");
				return "redirect:/bikes/list";
			} else {


			bS.insert(bike);
			model.addAttribute("mensaje", "Se guardó correctamente");
			model.addAttribute("listBike", bS.list());
			return "redirect:/bikes/list";
			}
		}
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/list")
	public String listBike(Model model) {
		try {
			model.addAttribute("listBike", bS.list());
			model.addAttribute("bike",new Bike());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "bike/listBike";

	}

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Bike> objBi = bS.searchId(id);
		if (objBi == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/bikes/list";
		} else {
			model.addAttribute("listBrands", brS.list());
			model.addAttribute("listStatus", sS.list());
			model.addAttribute("bike", objBi.get());
			return "bike/bikeUpdate";
		}
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verPhotoBike(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/view/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {

		Optional<Bike> bike = bS.searchId(id);
		if (bike == null) {
			flash.addFlashAttribute("error", "La bicicleta no existe en la base de datos");
			return "redirect:/bikes/list";
		}
		model.addAttribute("bike", bike.get());
		return "bike/view";
	}

	@RequestMapping("/search")
	public String searchBikes(Model model, @Validated Bike bike) throws ParseException {
		List<Bike> listBikes;
		listBikes = bS.search(bike.getIdBike());
		model.addAttribute("bike", new Bike());
		if (listBikes.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listBike", listBikes);
		return "bike/listBike";

	}
	
}
