package com.Sample.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2583931609844011707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dis1;
	private String n1;
	private String t1;
	private String n2;
	private String t2;

	private String dis2;
	private String no1;
	private String te1;
	private String no2;
	private String te2;

	private String dis3;
	private String not1;
	private String tes1;
	private String not2;
	private String tes2;

	private String dis4;
	private String nota1;
	private String test1;
	private String nota2;
	private String test2;

	private String dis5;

	private String notaa1;
	private String teste1;
	private String notaa2;
	private String teste2;

	private String dis6;
	private String notaaa1;
	private String testee1;
	private String notaaa2;
	private String testee2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDis1() {
		return dis1;
	}

	public void setDis1(String dis1) {
		this.dis1 = dis1;
	}

	public String getN1() {
		return n1;
	}

	public void setN1(String n1) {
		this.n1 = n1;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getDis2() {
		return dis2;
	}

	public void setDis2(String dis2) {
		this.dis2 = dis2;
	}

	public String getNo1() {
		return no1;
	}

	public void setNo1(String no1) {
		this.no1 = no1;
	}

	public String getTe1() {
		return te1;
	}

	public void setTe1(String te1) {
		this.te1 = te1;
	}

	public String getNo2() {
		return no2;
	}

	public void setNo2(String no2) {
		this.no2 = no2;
	}

	public String getTe2() {
		return te2;
	}

	public void setTe2(String te2) {
		this.te2 = te2;
	}

	public String getDis3() {
		return dis3;
	}

	public void setDis3(String dis3) {
		this.dis3 = dis3;
	}

	public String getNot1() {
		return not1;
	}

	public void setNot1(String not1) {
		this.not1 = not1;
	}

	public String getTes1() {
		return tes1;
	}

	public void setTes1(String tes1) {
		this.tes1 = tes1;
	}

	public String getNot2() {
		return not2;
	}

	public void setNot2(String not2) {
		this.not2 = not2;
	}

	public String getTes2() {
		return tes2;
	}

	public void setTes2(String tes2) {
		this.tes2 = tes2;
	}

	public String getDis4() {
		return dis4;
	}

	public void setDis4(String dis4) {
		this.dis4 = dis4;
	}

	public String getNota1() {
		return nota1;
	}

	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getNota2() {
		return nota2;
	}

	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getDis5() {
		return dis5;
	}

	public void setDis5(String dis5) {
		this.dis5 = dis5;
	}

	public String getNotaa1() {
		return notaa1;
	}

	public void setNotaa1(String notaa1) {
		this.notaa1 = notaa1;
	}

	public String getTeste1() {
		return teste1;
	}

	public void setTeste1(String teste1) {
		this.teste1 = teste1;
	}

	public String getNotaa2() {
		return notaa2;
	}

	public void setNotaa2(String notaa2) {
		this.notaa2 = notaa2;
	}

	public String getTeste2() {
		return teste2;
	}

	public void setTeste2(String teste2) {
		this.teste2 = teste2;
	}

	public String getDis6() {
		return dis6;
	}

	public void setDis6(String dis6) {
		this.dis6 = dis6;
	}

	public String getNotaaa1() {
		return notaaa1;
	}

	public void setNotaaa1(String notaaa1) {
		this.notaaa1 = notaaa1;
	}

	public String getTestee1() {
		return testee1;
	}

	public void setTestee1(String testee1) {
		this.testee1 = testee1;
	}

	public String getNotaaa2() {
		return notaaa2;
	}

	public void setNotaaa2(String notaaa2) {
		this.notaaa2 = notaaa2;
	}

	public String getTestee2() {
		return testee2;
	}

	public void setTestee2(String testee2) {
		this.testee2 = testee2;
	}

}
