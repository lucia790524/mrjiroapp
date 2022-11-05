package co.com.mrjiro.springboot.app.models.dao;
import org.springframework.data.repository.CrudRepository;
import co.com.mrjiro.springboot.app.persistence.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	

}
