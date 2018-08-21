package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Banco;

@Repository
public interface BancoRepository extends CrudRepository<Banco, Long> {

}
