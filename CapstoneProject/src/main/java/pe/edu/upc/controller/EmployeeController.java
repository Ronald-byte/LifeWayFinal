package pe.edu.upc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
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

import pe.edu.upc.entity.Employee;
import pe.edu.upc.serviceinterface.IEmployeeService;
import pe.edu.upc.serviceinterface.ITypeEmployeeService;
import pe.edu.upc.serviceinterface.IUploadFileService;

@Controller
@RequestMapping("/employees")
@Secured("ROLE_ADMIN")
public class EmployeeController {

	@Autowired
	private IEmployeeService eS;

	@Autowired
	private ITypeEmployeeService teS;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("listTypeEmployees", teS.list());
		model.addAttribute("employee", new Employee());
		return "employee/employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@Validated Employee employee, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listTypeEmployees", teS.list());
			return "employee/employee";
		} else {
			
			if (!foto.isEmpty()) {

				if (employee.getIdEmployee() > 0 && employee.getPhotoEmployee() != null
						&& employee.getPhotoEmployee().length() > 0) {

					uploadFileService.delete(employee.getPhotoEmployee());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				employee.setPhotoEmployee(uniqueFilename);
			}
			
			if (employee.getIdEmployee() > 0) {

				// posible ubicacion

				eS.update(employee);
				model.addAttribute("listEmployee", eS.list());
				model.addAttribute("mensaje", "Se actualizo correctamente");
				return "redirect:/employees/list";
			} else {

				

				int rpta = eS.insert(employee);
				if (rpta > 0) {
					model.addAttribute("mensaje", "Ya existe el empleado");
					model.addAttribute("listTypeEmployees", teS.list());
					return "employee/employee";
				} else {
					eS.insert(employee);
					model.addAttribute("mensaje", "Se guardo correctamente");
					status.setComplete();
					model.addAttribute("listEmployee", eS.list());
					return "redirect:/employees/list";
				}
			}

		}
		// REGLA DE NEGOCIO
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		try {
			model.addAttribute("listEmployee", eS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "employee/listEmployee";

	}

	@RequestMapping("/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				eS.delete(id);
			}
			model.addAttribute("listEmployee", eS.list());
			model.addAttribute("mensaje", "Se elmino al empleado correctamente");
		} catch (Exception e) {
			model.addAttribute("error", "ocurrio un error");
			System.out.println(e.getMessage());
			model.addAttribute("listEmployee", eS.list());
		}
		return "employee/listEmployee";
	}

	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Employee> objEmp = eS.searchId(id);
		if (objEmp == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error al actualizar");
			return "redirect:/employees/list";
		} else {
			model.addAttribute("listTypeEmployees", teS.list());
			// trae los datos
			model.addAttribute("employee", objEmp.get());
			return "employee/employeeUpdate";
		}
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/view/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {

		Optional<Employee> employee = eS.searchId(id);
		if (employee == null) {
			flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
			return "redirect:/employees/list";
		}

		model.addAttribute("employee", employee.get());

		return "employee/view";
	}

}