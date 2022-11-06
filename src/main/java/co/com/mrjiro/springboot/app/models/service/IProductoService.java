package co.com.mrjiro.springboot.app.models.service;

import co.com.mrjiro.springboot.app.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public void save(Producto producto);
    public Producto findOne(Long id);
    public void delete(Long id);

}
