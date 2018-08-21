package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Disciplina;
import com.Sample.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public Object findAll() {
		return disciplinaRepository.findAll();
	}

	public Disciplina findById(Long id) {
		return disciplinaRepository.findOne(id);
	}

	public Disciplina save(Disciplina semestre) {
		return disciplinaRepository.save(semestre);
	}

	public void delete(Disciplina semestre) {
		disciplinaRepository.delete(semestre);
		return;
	}

}
