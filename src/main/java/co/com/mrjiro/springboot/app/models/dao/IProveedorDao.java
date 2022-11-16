package co.com.mrjiro.springboot.app.models.dao;
import co.com.mrjiro.springboot.app.models.entity.Proveedor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProveedorDao extends PagingAndSortingRepository<Proveedor,Long> {
}
