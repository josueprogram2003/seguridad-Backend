package uc.us_security.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private int id;
	private String username;
	private String password;
	private boolean estado;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "idusuario"),
        inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "idrol"))
	private List<Rol> roles;
	
	public boolean getEstado() {
		return this.estado;
	}
}
