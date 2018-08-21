package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Nota;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {

}
