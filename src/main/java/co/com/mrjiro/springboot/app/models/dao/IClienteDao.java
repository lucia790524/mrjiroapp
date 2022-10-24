package co.com.mrjiro.springboot.app.models.dao;

import java.util.List;

import co.com.mrjiro.springboot.app.models.entity.Cliente;

public interface IClienteDao {
	
	// BUSCAR TODOS --> FINDALL
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void  delete(Long id);
}
