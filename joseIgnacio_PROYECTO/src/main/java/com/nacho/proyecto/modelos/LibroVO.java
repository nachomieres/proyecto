package com.nacho.proyecto.modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="libros")
public class LibroVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlibro;
	private String Titulo;
	private String ISBN;
	private String portada;

	@JoinTable(
        name = "rel_libros_autores",
        joinColumns = @JoinColumn(name = "FK_LIBRO", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_AUTOR", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AutorVO> autores;
	
	@JoinTable(
	        name = "rel_libros_usuarios",
	        joinColumns = @JoinColumn(name = "FK_LIBRO", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_USUARIO", nullable = false)
	    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UsuarioVO> usuarios ;

	public LibroVO() {
		super();
	}

	public LibroVO(String titulo, String iSBN, String portada, List<AutorVO> autores, List<UsuarioVO> usuarios) {
		super();
		Titulo = titulo;
		ISBN = iSBN;
		this.portada = portada;
		this.autores = autores;
		this.usuarios = usuarios;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public List<AutorVO> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorVO> autores) {
		this.autores = autores;
	}

	public List<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + idlibro;
		result = prime * result + ((portada == null) ? 0 : portada.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		LibroVO other = (LibroVO) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (idlibro != other.idlibro)
			return false;
		if (portada == null) {
			if (other.portada != null)
				return false;
		} else if (!portada.equals(other.portada))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibroVO [idlibro=" + idlibro + ", Titulo=" + Titulo + ", ISBN=" + ISBN + ", portada=" + portada
				+ ", autores=" + autores + ", usuarios=" + usuarios + "]";
	}

	


}
