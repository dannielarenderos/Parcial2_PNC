package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}


	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		return categoriaDAO.findOne(code);
	}


	@Override
	public void save(Categoria categoria) throws DataAccessException {
		categoriaDAO.save(categoria);		
	}


	@Override
	public void delete(Integer codigoCategoria) throws DataAccessException {
		categoriaDAO.delete(codigoCategoria);		
	}
}
