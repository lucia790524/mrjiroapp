package co.com.mrjiro.springboot.app.models.service;

import co.com.mrjiro.springboot.app.models.dao.IProveedorDao;
import co.com.mrjiro.springboot.app.models.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor findOne(Long idProveedor) {
        return proveedorDao.findById(idProveedor).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idCliente) {
        proveedorDao.deleteById(idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Proveedor> findAll(Pageable pageable) {
        return proveedorDao.findAll(pageable);
    }

}
