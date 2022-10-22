package co.com.mrjiro.springboot.app.models.dao;

import java.util.List;

import co.com.mrjiro.springboot.app.models.entity.Producto;

public interface IProductoDao {
	
	public List<Producto> findAll();
	
	public void save(Producto producto);

}
