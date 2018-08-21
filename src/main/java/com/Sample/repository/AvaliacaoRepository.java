package com.Sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Avaliacoes;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacoes, Long> {
	@Query("SELECT DISTINCT e FROM Avaliacoes e INNER JOIN e.matricula t  WHERE t.id=:id")
	public List<Avaliacoes> ineer(@Param("id") Long id);
	
}
