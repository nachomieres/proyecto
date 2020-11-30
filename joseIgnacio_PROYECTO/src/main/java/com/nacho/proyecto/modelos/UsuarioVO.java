
package com.nacho.proyecto.modelos;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(length = 36, unique = true)
	private String username;

	@Column(length = 128)
	private String password;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Set<UsuarioRolVO> roles;
	
	@ManyToMany(mappedBy = "usuarios")
    private List<LibroVO> libros;
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userId) {
		this.userid = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String encrytedPassword) {
		this.password = encrytedPassword;
	}

	public Set<UsuarioRolVO> getRoles() {
		return roles;
	}

	public void setRoles(Set<UsuarioRolVO> roles) {
		this.roles = roles;
	}

}