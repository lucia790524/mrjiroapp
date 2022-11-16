package co.com.mrjiro.springboot.app.models.dao;

import co.com.mrjiro.springboot.app.models.entity.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductoDao extends PagingAndSortingRepository<Producto,Long> {
}
