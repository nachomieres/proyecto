package com.nacho.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="libros")
public class LibroVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlibro;
	private String Titulo;
	private String ISBN;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@JoinTable(
        name = "rel_libros_autores",
        joinColumns = @JoinColumn(name = "FK_LIBRO", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_AUTOR", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AutorVO> autores;
	
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
	
	
	
	public List<AutorVO> getAutores() {
		return autores;
	}
	public void setAutores(List<AutorVO> autores) {
		this.autores = autores;
	}
	public LibroVO(int idlibro, String titulo) {
		super();
		this.idlibro = idlibro;
		Titulo = titulo;
	}
	
	public LibroVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
		result = prime * result + idlibro;
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
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		if (idlibro != other.idlibro)
			return false;
		return true;
	}
	
	public void addAutor(AutorVO autor){
        if(this.autores == null){
            this.autores = new ArrayList<>();
        }        
        this.autores.add(autor);
    }
	
	

}
