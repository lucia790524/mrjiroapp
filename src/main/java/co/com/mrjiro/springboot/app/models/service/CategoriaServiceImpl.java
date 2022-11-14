package co.com.mrjiro.springboot.app.models.service;

import co.com.mrjiro.springboot.app.models.dao.ICategoriaDao;
import co.com.mrjiro.springboot.app.models.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) this.categoriaDao.findAll();
    }

    @Override
    @Transactional
    public Page<Categoria> findAll(Pageable pageable) {
        return this.categoriaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        this.categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public Categoria findOne(Long idCategoria) {
        return this.categoriaDao.findById(idCategoria).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idCategoria) {
        this.categoriaDao.deleteById(idCategoria);
    }
}
