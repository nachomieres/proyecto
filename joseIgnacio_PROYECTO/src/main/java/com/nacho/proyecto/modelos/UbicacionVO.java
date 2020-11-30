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

}
