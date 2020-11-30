package com.nacho.proyecto.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="autores")
public class AutorVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idautor;
	private String nombre;
	
	@ManyToMany(mappedBy = "autores")
    private List<LibroVO> libros;

	public int getIdautor() {
		return idautor;
	}

	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LibroVO> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroVO> libros) {
		this.libros = libros;
	}

	public AutorVO(int idautor, String nombre, List<LibroVO> libros) {
		super();
		this.idautor = idautor;
		this.nombre = nombre;
		this.libros = libros;
	}

	public AutorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idautor;
		result = prime * result + ((libros == null) ? 0 : libros.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorVO other = (AutorVO) obj;
		if (idautor != other.idautor)
			return false;
		if (libros == null) {
			if (other.libros != null)
				return false;
		} else if (!libros.equals(other.libros))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
