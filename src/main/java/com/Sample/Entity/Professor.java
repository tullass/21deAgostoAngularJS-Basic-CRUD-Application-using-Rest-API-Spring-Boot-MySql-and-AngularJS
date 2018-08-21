package com.Sample.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5704195513528309669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String datanascimento;
	private String ecivil;
	private String genero;
	private String nivel;
	private String email;
	private String telefonei;
	private String telefoneii;
	private String area;
	GregorianCalendar calendar = new GregorianCalendar();
	private int data = calendar.getWeekYear();
	
	@ManyToOne
	private Cargos cargo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Adminstrativo administrativo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "prof_disc", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "disciplina_id") })
	private List<Disciplina> disciplina = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "profe_turma", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "turma_id") })
	private List<Turma> turma = new ArrayList<>();

	public Professor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getEcivil() {
		return ecivil;
	}

	public void setEcivil(String ecivil) {
		this.ecivil = ecivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonei() {
		return telefonei;
	}

	public void setTelefonei(String telefonei) {
		this.telefonei = telefonei;
	}

	public String getTelefoneii() {
		return telefoneii;
	}

	public void setTelefoneii(String telefoneii) {
		this.telefoneii = telefoneii;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	public Adminstrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Adminstrativo administrativo) {
		this.administrativo = administrativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	
}
