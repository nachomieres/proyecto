package com.nacho.proyecto.modelos;

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
	
	
	
	
	

	
	


}
