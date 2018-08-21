package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Turma;
import com.Sample.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Turma findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Turma save(Turma fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Turma fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
