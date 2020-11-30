package com.nacho.proyecto.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "ubicaciones")
public class UbicacionVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idubicacion;
	private String nombre;
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ubicacion_id")
    private List<LibroVO> libros;

	public UbicacionVO() {
		super();
	}

	public UbicacionVO(String nombre, String descripcion, List<LibroVO> libros) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.libros = libros;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LibroVO> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroVO> libros) {
		this.libros = libros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idubicacion;
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
		UbicacionVO other = (UbicacionVO) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idubicacion != other.idubicacion)
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

	@Override
	public String toString() {
		return "UbicacionVO [idubicacion=" + idubicacion + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", libros=" + libros + "]";
	}

	
}
