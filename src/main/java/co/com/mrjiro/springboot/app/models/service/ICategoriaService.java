package co.com.mrjiro.springboot.app.models.service;
import co.com.mrjiro.springboot.app.models.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ICategoriaService {
    public List<Categoria> findAll();
    public Page<Categoria> findAll(Pageable pageable);
    public void save(Categoria categoria);
    public Categoria findOne(Long idCategoria);
    public void  delete(Long idCategoria);
}
