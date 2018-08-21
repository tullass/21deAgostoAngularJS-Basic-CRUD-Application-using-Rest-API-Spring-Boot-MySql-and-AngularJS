package com.Sample.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Encaregado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3389348371869211512L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomepai;;
	private String profissaopai;
	private String telefonepai;
	private String emailpai;
	private String nomemae;
	private String profissaomae;
	private String emailmae;
	private String telefonemae;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomepai() {
		return nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getProfissaopai() {
		return profissaopai;
	}

	public void setProfissaopai(String profissaopai) {
		this.profissaopai = profissaopai;
	}

	public String getTelefonepai() {
		return telefonepai;
	}

	public void setTelefonepai(String telefonepai) {
		this.telefonepai = telefonepai;
	}

	public String getEmailpai() {
		return emailpai;
	}

	public void setEmailpai(String emailpai) {
		this.emailpai = emailpai;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getProfissaomae() {
		return profissaomae;
	}

	public void setProfissaomae(String profissaomae) {
		this.profissaomae = profissaomae;
	}

	public String getEmailmae() {
		return emailmae;
	}

	public void setEmailmae(String emailmae) {
		this.emailmae = emailmae;
	}

	public String getTelefonemae() {
		return telefonemae;
	}

	public void setTelefonemae(String telefonemae) {
		this.telefonemae = telefonemae;
	}

}
