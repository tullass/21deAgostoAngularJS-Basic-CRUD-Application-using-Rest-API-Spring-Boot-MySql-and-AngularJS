package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Matricula;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long> {

	
	
}
