package com.uca.capas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query =  entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> res = query.getResultList();		
	
		return res;

	}
	
	@Override
	public Libro findOne(Integer code) throws DataAccessException {
	
		Libro libro = entityManager.find(Libro.class, code);
		return libro;
	}
	
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException{
		try {

			if(libro.getC_libro() == null) {
				entityManager.persist(libro); 
			}
			else {
				entityManager.merge(libro);
				entityManager.flush();
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	@Transactional
	public void delete(Integer codigoLibro) throws DataAccessException{
	
	Libro libro = entityManager.find(Libro.class, codigoLibro);
	entityManager.remove(libro);
	}
	
}
