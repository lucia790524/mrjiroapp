package co.com.mrjiro.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.mrjiro.springboot.app.models.dao.IProductoDao;
import co.com.mrjiro.springboot.app.models.entity.Producto;

@Controller
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
    @RequestMapping(value = "/registro/producto",method = RequestMethod.POST)
    public String guardar(Producto producto) {
    	productoDao.save(producto);
    	return "redirect:/productos";
    }
}
