package co.com.mrjiro.springboot.app.models.service;

import java.util.List;

import co.com.mrjiro.springboot.app.persistence.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long idCliente);
	
	public void  delete(Long idCliente);
}
