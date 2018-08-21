package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

}
