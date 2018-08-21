package com.Sample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Fatura;

@Repository
public interface FaturaRepository extends CrudRepository<Fatura, Long> {

	public List<Fatura> findByAdiantamento(Boolean adiantamento);
	public Fatura findByMesDescricao(String descricao);


	@Query("SELECT c FROM Fatura c WHERE c.adiantamento=true AND c.inscrito=true")
	public Iterable<Fatura> querey();

	@Query("SELECT c FROM Fatura c WHERE c.pagou=true")
	public Iterable<Fatura> pagou();

	@Query("SELECT c FROM Fatura c WHERE c.adiantamento=true AND c.inscrito=true")
	public Page<Fatura> findByNome(Pageable page);

	@Query("SELECT SUM (f.caixa)  AS total from Fatura f WHERE f.caixa>0")
	public Long avg();

	@Query(value = "SELECT * FROM Fatura as f WHERE f.id>0 ORDER BY f.id DESC LIMIT 1", nativeQuery = true)
	public List<Fatura> nativee();

	@Query(value = "SELECT * FROM Fatura as f WHERE f.id>0 ORDER BY f.calendar DESC LIMIT 1", nativeQuery = true)
	public Iterable<Fatura> pendentes();

	@Query(value = "SELECT * FROM Fatura as f WHERE f.id= :id", nativeQuery = true)
	public List<Fatura> encotraId(@Param("id") Long id);
	
//	@Query("SELECT DISTINCT e FROM Fatura e INNER JOIN e.matricula t INNER JOIN t.aluno ORDER BY e.calendar ")
//	public List<Fatura> findAlll();
	
	@Query("SELECT DISTINCT e FROM Fatura e INNER JOIN e.matricula t INNER JOIN t.aluno WHERE t.id=:id")
	public List<Fatura> ineer(@Param("id") Long id);
	
	@Query("SELECT DISTINCT e FROM Fatura e INNER JOIN e.professor p INNER JOIN e.mes m WHERE p.id=:id")
	public List<Fatura> ineerP(@Param("id") Long id);
	
	
	
}
