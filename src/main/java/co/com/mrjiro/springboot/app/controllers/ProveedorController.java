package co.com.mrjiro.springboot.app.controllers;

import co.com.mrjiro.springboot.app.models.entity.Proveedor;
import co.com.mrjiro.springboot.app.models.service.IProveedorService;
import co.com.mrjiro.springboot.app.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes ("proveedor")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@RequestMapping(value="/proveedores", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page,5);
		Page<Proveedor> proveedores = proveedorService.findAll(pageRequest);
		PageRender<Proveedor> pageRender =  new PageRender<>("/proveedores", proveedores);

		model.addAttribute("titulo", "Listado de Proveedores");
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("page", pageRender);
		return "formularios/frm_buscar_proveedor";
	}

	@RequestMapping(value = "/registro/proveedor")
	public String crear(Map<String, Object> model) {
		Proveedor proveedor = new Proveedor();
		model.put("proveedor", proveedor);
		model.put("titulo", "Registro Proveedor");
		return "formularios/frm_registro_proveedor";
	}
	
	@RequestMapping(value="/registro/proveedor/{idProveedor}")
	public String editar(@PathVariable(value="idProveedor") Long idProveedor, Map<String, Object> model) {
		
		Proveedor proveedor = null;
		
		if(idProveedor>0) {
			proveedor = proveedorService.findOne(idProveedor);
		}
		else {
			return "redirect:/proveedores";
		}
		model.put("proveedor", proveedor);
		model.put("titulo", "Editar Proveedor");
		return "formularios/frm_registro_proveedor";
	}
	
	@RequestMapping(value = "/registro/proveedor",method = RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registro Proveedor");
			return "formularios/frm_registro_proveedor";
		}
		proveedorService.save(proveedor);
		status.setComplete();
		return "redirect:/proveedores";
	}
	@RequestMapping(value = "eliminar/proveedor/{idProveedor}")
	public String eliminar(@PathVariable(value="idProveedor")Long idProveedor) {
		if(idProveedor>0) {
			proveedorService.delete(idProveedor);
		}
		return "redirect:/proveedores";
	}

}
