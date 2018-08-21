package com.Sample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Avaliacoes;
import com.Sample.repository.AvaliacaoRepository;

@Service
public class AvaliacaoesService {

	@Autowired
	private AvaliacaoRepository semestreRepository;

	public Object findAll() {
		return semestreRepository.findAll();
	}

	public Avaliacoes findById(Long id) {
		return semestreRepository.findOne(id);
	}
	

	public Avaliacoes save(Avaliacoes semestre) {
		return semestreRepository.save(semestre);
	}

	public void delete(Avaliacoes semestre) {
		semestreRepository.delete(semestre);
		return;
	}
	public List<Avaliacoes> innerJ(Long id) {
		return semestreRepository.ineer(id);
	}
}
