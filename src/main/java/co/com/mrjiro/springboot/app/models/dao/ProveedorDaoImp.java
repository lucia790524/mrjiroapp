package co.com.mrjiro.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.mrjiro.springboot.app.models.entity.Proveedor;

@Repository
public class ProveedorDaoImp implements IProveedorDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Proveedor> findAll() {
		return em.createQuery("from Proveedor").getResultList();
	}

	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		if (proveedor.getId() != null && proveedor.getId() > 0) {
			em.merge(proveedor);
		} else {
			em.persist(proveedor);

		}
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findOne(Long id) {
		return em.find(Proveedor.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
