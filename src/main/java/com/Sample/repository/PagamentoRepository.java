package com.Sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Sample.Entity.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

}
