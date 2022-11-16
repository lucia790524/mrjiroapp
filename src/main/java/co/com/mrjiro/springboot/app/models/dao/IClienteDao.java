package co.com.mrjiro.springboot.app.models.dao;
import co.com.mrjiro.springboot.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long> {
}
