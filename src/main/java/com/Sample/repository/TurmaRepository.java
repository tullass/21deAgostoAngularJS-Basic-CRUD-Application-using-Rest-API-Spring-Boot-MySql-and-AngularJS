package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {

}
