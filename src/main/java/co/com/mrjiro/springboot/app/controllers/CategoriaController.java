package co.com.mrjiro.springboot.app.controllers;

import co.com.mrjiro.springboot.app.models.entity.Categoria;
import co.com.mrjiro.springboot.app.models.service.ICategoriaService;
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
@SessionAttributes ("categorias")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping(value="/categorias", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page,5);
		Page<Categoria> categorias = categoriaService.findAll(pageRequest);
		PageRender<Categoria> pageRender =  new PageRender<>("/categorias", categorias);

		model.addAttribute("titulo", "Listado de Categorias");
		model.addAttribute("categorias", categorias);
		model.addAttribute("page", pageRender);
		return "formularios/frm_buscar_cliente";
	}

	@RequestMapping(value = "/registro/categoria")
	public String crear(Map<String, Object> model) {
		Categoria categoria = new Categoria();
		model.put("categoria", categoria);
		model.put("titulo", "Registro categoria");
		model.put("btnCategoria", "Crear categoria");
		return "formularios/frm_registro_categoria";
	}
	
	@RequestMapping(value="/registro/categoria/{idCategoria}")
	public String editar(@PathVariable(value="idCategoria") Long idCategoria, Map<String, Object> model) {
		
		Categoria categoria = null;
		
		if(idCategoria>0) {
			categoria = categoriaService.findOne(idCategoria);
		}
		else {
			return "redirect:/categorias";
		}
		model.put("categoria", categoria);
		model.put("titulo", "Editar Categoria");
		return "formularios/frm_registro_categoria";
	}
	
	@RequestMapping(value = "/registro/categoria",method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registro Categoria");
			return "formularios/frm_registro_categoria";
		}
		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:/registro/producto";
	}
	@RequestMapping(value = "eliminar/categoria/{idCategoria}")
	public String eliminar(@PathVariable(value="idCategoria")Long idCategoria) {
		if(idCategoria>0) {
			categoriaService.delete(idCategoria);
		}
		return "redirect:/categorias";
	}

}
