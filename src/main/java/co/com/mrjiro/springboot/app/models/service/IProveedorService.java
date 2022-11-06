package co.com.mrjiro.springboot.app.models.service;

import co.com.mrjiro.springboot.app.models.entity.Proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProveedorService {
	public List<Proveedor> findAll();
	public Page<Proveedor> findAll(Pageable pageable);
	public void save(Proveedor proveedor);
	public Proveedor findOne(Long idProveedor);
	public void  delete(Long idProveedor);
}
