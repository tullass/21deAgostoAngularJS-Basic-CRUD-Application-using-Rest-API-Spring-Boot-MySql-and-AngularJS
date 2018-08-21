package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}
