package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro{
	
	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name="c_libro")
	private Integer c_libro;
	
	
	@Size(message="El campo sobrepasar la cantidad de 500 caracteres", max=500)
	@NotEmpty(message="El campo no puede estar vacío")
	@Column(name="s_titulo")
	private String s_titulo;
	
	@Size(message="El campo sobrepasar la cantidad de 150 caracteres", max=150)
	@NotEmpty(message="El campo no puede estar vacío")
	@Column(name="s_autor")
	private String s_autor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_ingreso")
	private Date f_ingreso;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_categoria")
	private Categoria c_categoria;
	
	
	@Size(message="El campo sobrepasar la cantidad de 10 caracteres", max=10)
	@NotEmpty(message="El campo no puede estar vacío")
	@Column(name="s_isbn")
	private String s_isbn;
	
	
	@Column(name = "b_estado")
	private Boolean b_estado;	
	
	
	
	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	@Transient
	private Integer ccategoria;
	

	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}

	public Libro() {

	}

	

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Categoria getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Categoria c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getFingresoDelegate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(f_ingreso);
		
	}
	
	public String getEstadoDelegate() {
		if(this.b_estado == null ) return "Inactivo";
		else {
			return b_estado == true?"Activo":"Inactivo";
		}
	}
	
	
	

	
	
}
	