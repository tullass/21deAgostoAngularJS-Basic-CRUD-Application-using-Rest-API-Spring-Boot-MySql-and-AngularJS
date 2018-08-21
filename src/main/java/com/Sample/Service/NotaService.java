package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Nota;
import com.Sample.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Nota findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Nota save(Nota fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Nota fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
