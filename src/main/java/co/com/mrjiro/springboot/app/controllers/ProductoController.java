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
import co.com.mrjiro.springboot.app.models.dao.IProductoDao;
import co.com.mrjiro.springboot.app.models.dao.entity.Producto;

@Controller
@SessionAttributes ("producto")
public class ProductoController {
	
	@Autowired
	private IProductoDao  productoDao;
	
	
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public String listarProduto(Model model) {
		model.addAttribute("titulo","Listado de Producto");
		model.addAttribute("productos",productoDao.findAll());
		return "formularios/frm_buscar_producto";
	}
	
	@RequestMapping(value = "/registro/producto")
	public String crear(Map<String,Object>model) {
		Producto producto = new Producto();
		model.put("producto",producto);
		model.put("titulo","Formulario Producto");
		return "formularios/frm_registro_producto";

	}
	@RequestMapping(value="/registro/producto/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Producto producto = null;
		if(id>0) {
			producto = productoDao.findOne(id);
		}
		else {
			return "redirect:/productos";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "formularios/frm_registro_producto";
	
	}

	
	
    @RequestMapping(value = "/registro/producto",method = RequestMethod.POST)
    public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
    	if(result.hasErrors()) {
    		model.addAttribute("titulo", "Registro Producto");
			return "formularios/frm_registro_producto";	
    	}
    	productoDao.save(producto);
        status.setComplete();
 	   return "redirect:/productos";
    }
    
    @RequestMapping(value = "eliminar/producto/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
    	
    	if(id>0) {
    		productoDao.delete(id);
    		
    	}
    		
    	 return "redirect:/productos";
    	
    }
       
}
