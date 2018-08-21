package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Cargos;

@Repository
public interface CargoRepository extends CrudRepository<Cargos, Long> {

}
