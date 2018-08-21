package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Nivel;

@Repository
public interface NivelRepository extends CrudRepository<Nivel, Long> {

}
