package co.com.mrjiro.springboot.app.models.dao;
import co.com.mrjiro.springboot.app.models.entity.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoriaDao extends PagingAndSortingRepository<Categoria,Long> {
}
