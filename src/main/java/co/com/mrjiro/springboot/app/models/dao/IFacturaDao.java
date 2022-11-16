package co.com.mrjiro.springboot.app.models.dao;

import co.com.mrjiro.springboot.app.models.entity.Factura;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFacturaDao extends PagingAndSortingRepository<Factura, Long> {

}
