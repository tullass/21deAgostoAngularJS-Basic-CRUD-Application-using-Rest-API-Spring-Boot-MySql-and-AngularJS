package com.Sample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Sample.Entity.Fatura;
import com.Sample.repository.FaturaRepository;

@Service
public class FaturaService {

	@Autowired
	private FaturaRepository faturaRepository;

	public Object findAll() {
		return faturaRepository.findAll();
	}

	public Object Pendentess() {
		return faturaRepository.pendentes();
	}

	public Object Querry() {
		return faturaRepository.querey();
	}

	public Object PagouSalaries() {
		return faturaRepository.pagou();
	}

	public List<Fatura> findByAdiantamentos(Boolean b) {
		return faturaRepository.findByAdiantamento(true);
	}
	

	public List<Fatura> innerJ(Long id) {
		return faturaRepository.ineer(id);
	}
	public List<Fatura> innerP(Long id) {
		return faturaRepository.ineerP(id);
	}

	public List<Fatura> encotra(Long id) {
		return faturaRepository.encotraId(id);
	}

	public Fatura findById(Long id) {
		return faturaRepository.findOne(id);
	}

	public Fatura findByMes(String descricao) {
		return faturaRepository.findByMesDescricao(descricao);
	}

	
	public List<Fatura> findBy() {
		return faturaRepository.nativee();
	}

	public Fatura save(Fatura fatura) {
		return faturaRepository.save(fatura);
	}

	public void delete(Fatura fatura) {
		faturaRepository.delete(fatura);
		return;
	}

	public Page<Fatura> findByNome(Pageable p) {
		return faturaRepository.findByNome(p);
	}

	public Long avg() {
		return faturaRepository.avg();
	}
}
