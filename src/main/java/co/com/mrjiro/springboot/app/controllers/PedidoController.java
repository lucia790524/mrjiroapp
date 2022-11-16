package co.com.mrjiro.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import co.com.mrjiro.springboot.app.models.dao.IProductoDao;

@Controller
@SessionAttributes ("pedido")
public class PedidoController {

	
		@Autowired
		private IProductoDao productoDao;
		
		@RequestMapping(value="/registro/pedido", method = RequestMethod.GET)
		public String listar(Model model) {
			model.addAttribute("titulo", "Listado de Pedidos");
			model.addAttribute("productos", productoDao.findAll());
			return "formularios/frm_registro_pedido";
		}
}
