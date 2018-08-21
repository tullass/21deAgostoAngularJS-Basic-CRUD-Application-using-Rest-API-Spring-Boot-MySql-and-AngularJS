package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Nivel;
import com.Sample.repository.NivelRepository;

@Service
public class NivelService {

	@Autowired
	private NivelRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Nivel findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Nivel save(Nivel fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Nivel fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
