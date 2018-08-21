package com.Sample.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Sample.Entity.Aluno;
import com.Sample.repository.AlunoRepository;

@Service
public class AlunoService implements AlunoServiceInterface{

	@Autowired
	private AlunoRepository documentDao;

	public Aluno saves(Aluno semestre) {
		return documentDao.save(semestre);
	}
	
//
//	public Aluno findById(Long id) {
//		return alunoRepository.findOne(id);
//	}
//
//	public Aluno save(Aluno aluno) {
//		return alunoRepository.save(aluno);
//	}
//
//	public void delete(Long id) {
//		alunoRepository.delete(id);
//		return;
//	}
	public Aluno findById(Long id) {
		return documentDao.findOne(id);
	}
	
	 @Override
	    public ResponseMetadata save(MultipartFile file) throws IOException {

	        Aluno doc = new Aluno();
	        doc.setDocName(file.getOriginalFilename());
	        doc.setFile(file.getBytes());
	        documentDao.save(doc);
	        ResponseMetadata metadata = new ResponseMetadata();
	        metadata.setMessage("success");
	        metadata.setStatus(200);
	        return metadata;
	    }

	    @Override
	    public byte[] getAlunoFile(Long id) {
	      return documentDao.findOne(id).getFile();
	    }

	    @Override
	    public List<Aluno> findAll() {
	        return (List<Aluno>) documentDao.findAll();
	    }  

}
