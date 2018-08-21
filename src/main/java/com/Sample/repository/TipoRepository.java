package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.TipoDoc;

@Repository
public interface TipoRepository extends CrudRepository<TipoDoc, Long> {

}
