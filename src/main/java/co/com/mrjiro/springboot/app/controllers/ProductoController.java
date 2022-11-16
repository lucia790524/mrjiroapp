package co.com.mrjiro.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import co.com.mrjiro.springboot.app.models.entity.Categoria;
import co.com.mrjiro.springboot.app.models.entity.Cliente;
import co.com.mrjiro.springboot.app.models.entity.Proveedor;
import co.com.mrjiro.springboot.app.models.service.ICategoriaService;
import co.com.mrjiro.springboot.app.models.service.IProductoService;
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
import co.com.mrjiro.springboot.app.models.entity.Producto;

@Controller
@SessionAttributes ("producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	@Autowired
	private ICategoriaService categoriaService;

	@Autowired
	private IProveedorService proveedorService;
	
	
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public String listarProduto(@RequestParam(name="page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page,5);
		Page<Producto> productos = productoService.findAll(pageRequest);
		PageRender<Producto> pageRender = new PageRender<>("/productos",productos);

		model.addAttribute("titulo","Listado de Producto");
		model.addAttribute("productos", productos);
		model.addAttribute("page", pageRender);
		return "formularios/frm_buscar_producto";
	}

	@RequestMapping(value = "/registro/producto")
	public String crear(Map<String,Object>model) {
		Producto producto = new Producto();
		List<Categoria> listaCategorias = categoriaService.findAll();
		List<Proveedor> listaProveedores = proveedorService.findAll();

		model.put("producto",producto);
		model.put("titulo","Registrar Producto");
		model.put("productoCategorias",listaCategorias);
		model.put("productoProveedor",listaProveedores);
		model.put("btnProducto", "Crear producto");
		return "formularios/frm_registro_producto";
	}
	@RequestMapping(value="/registro/producto/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Producto producto = null;
		List<Categoria> listaCategorias = categoriaService.findAll();
		List<Proveedor> listaProveedores = proveedorService.findAll();
		if(id>0) {
			producto = productoService.findOne(id);
		}
		else {
			return "redirect:/productos";
		}
		model.put("producto", producto);
		model.put("productoCategorias",listaCategorias);
		model.put("productoProveedor",listaProveedores);

		model.put("titulo", "Editar Producto");
		model.put("btnProducto", "Modificar producto");
		return "formularios/frm_registro_producto";
	
	}

    @RequestMapping(value = "/registro/producto",method = RequestMethod.POST)
    public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
    	if(result.hasErrors()) {
			List<Categoria> listaCategorias = categoriaService.findAll();
			List<Proveedor> listaProveedores = proveedorService.findAll();
    		model.addAttribute("titulo", "Registro Producto");
			model.addAttribute("productoCategorias",listaCategorias);
			model.addAttribute("productoProveedor",listaProveedores);
			model.addAttribute("btnProducto", "Crear producto");
			return "formularios/frm_registro_producto";	
    	}
    	productoService.save(producto);
        status.setComplete();
 	   return "redirect:/productos";
    }
    
    @RequestMapping(value = "eliminar/producto/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
    	if(id>0) {
    		productoService.delete(id);
    	}
    	 return "redirect:/productos";
    	
    }
       
}
