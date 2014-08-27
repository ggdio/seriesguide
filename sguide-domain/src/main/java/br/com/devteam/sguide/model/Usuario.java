package br.com.devteam.sguide.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.devteam.sguide.annotation.Encrypt;

@Entity
@SequenceGenerator(name = "GEN", sequenceName = "SEQ_SG_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN")
	private Integer id;

	private String nome;

	private String email;

	@Encrypt
	private String senha;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String nome, String email, String senha, Calendar dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}