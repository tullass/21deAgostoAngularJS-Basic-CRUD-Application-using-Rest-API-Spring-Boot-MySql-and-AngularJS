package com.Sample.Entity;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacoes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2583931609844011707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private String data;
	GregorianCalendar calendar = new GregorianCalendar();
	private int ano = calendar.getWeekYear();

	@ManyToOne
	private Turma turmaa;

	@ManyToOne
	private Semestre trimestre;

	@ManyToOne
	private Professor professor;

	@ManyToOne
	private Matricula matricula;

	@ManyToOne
	private Disciplina disciplina;

	@ManyToOne(cascade = CascadeType.ALL)
	private Avalia avalia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Turma getTurmaa() {
		return turmaa;
	}

	public void setTurmaa(Turma turmaa) {
		this.turmaa = turmaa;
	}

	public Semestre getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(Semestre trimestre) {
		this.trimestre = trimestre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Avalia getAvalia() {
		return avalia;
	}

	public void setAvalia(Avalia avalia) {
		this.avalia = avalia;
	}

}
