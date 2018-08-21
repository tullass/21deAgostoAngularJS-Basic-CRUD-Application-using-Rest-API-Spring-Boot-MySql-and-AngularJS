package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Semestre;
import com.Sample.repository.SemestreRepository;

@Service
public class SemestreService {

	@Autowired
	private SemestreRepository semestreRepository;

	public Object findAll() {
		return semestreRepository.findAll();
	}

	public Semestre findById(Long id) {
		return semestreRepository.findOne(id);
	}

	public Semestre save(Semestre semestre) {
		return semestreRepository.save(semestre);
	}

	public void delete(Semestre semestre) {
		semestreRepository.delete(semestre);
		return;
	}

}
