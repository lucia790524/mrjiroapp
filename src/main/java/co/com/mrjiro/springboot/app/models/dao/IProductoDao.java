package co.com.mrjiro.springboot.app.models.dao;

import java.util.List;

import co.com.mrjiro.springboot.app.models.dao.entity.Producto;

public interface IProductoDao {
	
	public List<Producto> findAll();
	
	public void save(Producto producto);

	public Producto findOne(Long id);
	
	public void delete(Long id);
	
}
