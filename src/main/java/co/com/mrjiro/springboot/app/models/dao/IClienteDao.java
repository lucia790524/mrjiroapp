package co.com.mrjiro.springboot.app.models.dao;
import co.com.mrjiro.springboot.app.models.dao.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long> {
}
