package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroDAO LibroDAO;
	
	@Autowired
	CategoriaService categoriaService;


	@Override
	public List<Libro> findAll() throws DataAccessException {
		return LibroDAO.findAll();
	}


	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		return LibroDAO.findOne(code);
	}


	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		libro.setC_categoria(categoriaService.findOne(libro.getCcategoria()));
		libro.setF_ingreso(new Date());
		LibroDAO.save(libro);		
	}


	@Override
	public void delete(Integer codigoLibro) throws DataAccessException {
		LibroDAO.delete(codigoLibro);		
	}
}
