package com.Sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Pagamento;
import com.Sample.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Pagamento findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Pagamento save(Pagamento fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Pagamento fatura) {
		faturaRepository.delete(fatura);
		return;
	}

}
