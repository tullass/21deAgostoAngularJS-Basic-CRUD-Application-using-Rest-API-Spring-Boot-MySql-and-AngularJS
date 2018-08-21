package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Cargos;
import com.Sample.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Cargos findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Cargos save(Cargos fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Cargos fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
