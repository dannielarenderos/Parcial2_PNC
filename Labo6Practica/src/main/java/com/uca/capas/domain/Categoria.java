package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {

	@Id
	@GeneratedValue(generator="cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_categoria_c_categoria_seq", sequenceName = "public.cat_categoria_c_categoria_seq", allocationSize = 1)
	@Column(name="c_categoria")
	private Integer c_categoria;
	
	@NotEmpty(message="El campo nombre categoría no puede estar vacío")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@Column(name="s_categoria")
	private String s_categoria;
	
	
	@OneToMany(mappedBy = "c_categoria", fetch = FetchType.LAZY)
	private List<Libro> libros;

	public Categoria() {
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_categoria() {
		return s_categoria;
	}

	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	
	
}
