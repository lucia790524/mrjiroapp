package co.com.mrjiro.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.mrjiro.springboot.app.models.dao.IProductoDao;

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
	

}
