package co.com.mrjiro.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.mrjiro.springboot.app.models.dao.IProductoDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.mrjiro.springboot.app.models.entity.Producto;

@Repository
public class ProductoServiceImpl implements IProductoService {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		if(producto.getIdProducto() !=null && producto.getIdProducto() >0 ) {
			em.merge(producto);
		}  else{
			em.persist(producto);
	}
}
     @Override
     @Transactional (readOnly = true )
     public Producto findOne(Long id) {
	  return em.find(Producto.class, id);
}
     @Override
     @Transactional
     public void delete(Long id) {
    	 em.remove(findOne(id));
     }
     

    	
}

	
