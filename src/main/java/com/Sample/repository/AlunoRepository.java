package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

		
}
