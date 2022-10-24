package co.com.mrjiro.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import co.com.mrjiro.springboot.app.models.dao.IProveedorDao;
import co.com.mrjiro.springboot.app.models.entity.Proveedor;

@Controller
@SessionAttributes("proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorDao proveedorDao;

	@RequestMapping(value = "/proveedores", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("proveedores", proveedorDao.findAll());
		return "formularios/frm_buscar_proveedor";
	}

	@RequestMapping(value = "/registro/proveedor")
	public String crear(Map<String, Object> model) {
		Proveedor proveedor = new Proveedor();
		model.put("proveedor", proveedor);
		model.put("titulo", "Registro Proveedor");
		return "formularios/frm_registro_proveedor";
	}

	@RequestMapping(value = "/registro/proveedor/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Proveedor proveedor = null;

		if (id > 0) {
			proveedor = proveedorDao.findOne(id);
		} else {
			return "redirect:/proveedores";
		}
		model.put("proveedor", proveedor);
		model.put("titulo", "Editar Proveedor");
		return "formularios/frm_registro_proveedor";
	}

	@RequestMapping(value = "/registro/proveedor", method = RequestMethod.POST)
	public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Registro Proveedor");
			return "formularios/frm_registro_proveedor";
		}
		proveedorDao.save(proveedor);
		status.setComplete();

		return "redirect:/proveedores";
	}

	@RequestMapping(value = "eliminar/proveedor/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			proveedorDao.delete(id);

		}
		return "redirect:/proveedores";
	}
}
