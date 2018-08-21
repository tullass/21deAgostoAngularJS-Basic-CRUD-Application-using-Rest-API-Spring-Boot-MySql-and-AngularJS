package com.Sample.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5268803107908071310L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	GregorianCalendar calendar = new GregorianCalendar();
	private int data = calendar.getWeekYear();
	private String valorSaida;
	private String multa;
	private String obs;
	private Long caixa;
	private String desconto;
	private String prestacao;
	private String pagamento;
	private String valorProfessor;

	private Boolean adiantamento;
	private Date datainicio;
	private Date datafim;
	private Boolean inscrito;
	private String tipoPagamento;
	private Boolean pagou;
	private Boolean despesa;

	@ManyToOne
	private Matricula matricula;

	@ManyToOne(cascade = CascadeType.ALL)
	private Mes mes;

	@ManyToOne(cascade = CascadeType.ALL)
	private Banco banco;

	@ManyToOne
	private Turma turma;

	@ManyToOne
	private TipoDoc tipo;

	@ManyToOne
	private Pagamento pagaprof;

	@ManyToOne
	private Professor professor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(String valorSaida) {
		this.valorSaida = valorSaida;
	}

	public String getMulta() {
		return multa;
	}

	public void setMulta(String multa) {
		this.multa = multa;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Long getCaixa() {
		return caixa;
	}

	public void setCaixa(Long caixa) {
		this.caixa = caixa;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getPrestacao() {
		return prestacao;
	}

	public void setPrestacao(String prestacao) {
		this.prestacao = prestacao;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getValorProfessor() {
		return valorProfessor;
	}

	public void setValorProfessor(String valorProfessor) {
		this.valorProfessor = valorProfessor;
	}

	public Boolean getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(Boolean adiantamento) {
		this.adiantamento = adiantamento;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafim() {
		return datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Boolean getInscrito() {
		return inscrito;
	}

	public void setInscrito(Boolean inscrito) {
		this.inscrito = inscrito;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public TipoDoc getTipo() {
		return tipo;
	}

	public void setTipo(TipoDoc tipo) {
		this.tipo = tipo;
	}

	public Pagamento getPagaprof() {
		return pagaprof;
	}

	public void setPagaprof(Pagamento pagaprof) {
		this.pagaprof = pagaprof;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Boolean getPagou() {
		return pagou;
	}

	public void setPagou(Boolean pagou) {
		this.pagou = pagou;
	}

	public Boolean getDespesa() {
		return despesa;
	}

	public void setDespesa(Boolean despesa) {
		this.despesa = despesa;
	}

}
