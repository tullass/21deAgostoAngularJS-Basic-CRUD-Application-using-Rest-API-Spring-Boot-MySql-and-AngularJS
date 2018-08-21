package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.TipoDoc;
import com.Sample.repository.TipoRepository;

@Service
public class TipoService {

	@Autowired
	private TipoRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public TipoDoc findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public TipoDoc save(TipoDoc fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(TipoDoc fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
