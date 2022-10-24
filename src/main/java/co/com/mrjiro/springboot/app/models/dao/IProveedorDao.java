package co.com.mrjiro.springboot.app.models.dao;

import java.util.List;
import co.com.mrjiro.springboot.app.models.entity.Proveedor;

public interface IProveedorDao {
	
	public List<Proveedor> findAll();
	
	public void save(Proveedor proveedor);
	
	public Proveedor findOne(Long id);
	
	public void delete(Long id);

}
