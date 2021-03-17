package com.example.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Mapeamento JPA
@Entity
@Table(name = "tb_user")
public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	/*
	 * Como a associalção entre User e Role é muitos-para-muitos,
	 * não pode haver repetição, então é utilizado a interface Set
	 * para registrar a lista de associações sem repetir.
	 * Lembrando que o Set é uma interface de modo que para 
	 * instanciá-lo é necessário colocar a classe que 
	 * o implementa chamada de HashSet.
	 * 
	 * A associação é unidirecional de User para role, de forma que
	 * só aqui é definida o conjunto contendo as associações.
	 * 
	 * Como é um relacionamento muitos-para-muitos, é necessário 
	 * uma terceira tabela contendo as duas chaves estrangeiras, sendo
	 * cada chave de user e de role. Para fazer isso automático, temos a
	 * anotação @JoinTable
	 * 
	 * O FetchType.EAGER é para que os dados dos perfis sejam automaticamente
	 * carregados juntos ao usuário.
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role", 
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		
	}

	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Set<Role> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
