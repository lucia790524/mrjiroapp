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

import co.com.mrjiro.springboot.app.persistence.entity.Cliente;
import co.com.mrjiro.springboot.app.models.service.IClienteService;

@Controller
@SessionAttributes ("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value="/clientes", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "formularios/frm_buscar_cliente";
	}
	
	
	
	@RequestMapping(value = "/registro/cliente")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Registro Cliente");
		return "formularios/frm_registro_cliente";
	}
	
	@RequestMapping(value="/registro/cliente/{idCliente}")
	public String editar(@PathVariable(value="idCliente") Long idCliente, Map<String, Object> model) {
		
		Cliente cliente = null;
		
		if(idCliente>0) {
			cliente = clienteService.findOne(idCliente);
		}
		else {
			return "redirect:/clientes";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "formularios/frm_registro_cliente";
	}
	
	@RequestMapping(value = "/registro/cliente",method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldError());
			model.addAttribute("titulo", "Registro Cliente");
			return "formularios/frm_registro_cliente";
		}
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:/clientes";
	}
	@RequestMapping(value = "eliminar/cliente/{idCliente}")
	public String eliminar(@PathVariable(value="idCliente")Long idCliente) {
		
		if(idCliente>0) {
			clienteService.delete(idCliente);
			
		}
			
		return "redirect:/clientes";
		
	}

}
