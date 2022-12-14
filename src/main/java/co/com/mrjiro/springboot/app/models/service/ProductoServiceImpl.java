package co.com.mrjiro.springboot.app.models.service;

import java.util.List;

import co.com.mrjiro.springboot.app.models.dao.IProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mrjiro.springboot.app.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Producto producto) {
		productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return productoDao.findAll(pageable);
    }
}

	
