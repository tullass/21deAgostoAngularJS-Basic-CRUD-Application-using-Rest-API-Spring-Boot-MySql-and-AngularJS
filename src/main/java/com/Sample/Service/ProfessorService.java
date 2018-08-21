package com.Sample.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.Sample.Entity.Professor;
import com.Sample.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public Object findAll() {
		return professorRepository.findAll();
	}

	public Professor findById(Long id) {
		return professorRepository.findOne(id);
	}

	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	public void delete(Long id) {
		professorRepository.delete(id);
		return;
	}

}
