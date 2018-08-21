package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Matricula;
import com.Sample.repository.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository MatriculaRepository;

	public Object findAll() {
		return MatriculaRepository.findAll();
	}

	public Matricula findById(Long id) {
		return MatriculaRepository.findOne(id);
	}

	public Matricula save(Matricula Matricula) {
		return MatriculaRepository.save(Matricula);
	}

	public void delete(Long id) {
		MatriculaRepository.delete(id);
		return;
	}

}
