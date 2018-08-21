package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Banco;
import com.Sample.repository.BancoRepository;

@Service
public class BancoService {

	@Autowired
	private BancoRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Banco findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Banco save(Banco fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Banco fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
