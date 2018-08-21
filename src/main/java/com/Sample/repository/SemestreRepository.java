package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Semestre;

@Repository
public interface SemestreRepository extends CrudRepository<Semestre, Long> {

}
