package com.Sample.Service;

import org.springframework.web.multipart.MultipartFile;

import com.Sample.Entity.Aluno;

import java.io.IOException;
import java.util.List;

public interface AlunoServiceInterface {

    ResponseMetadata save(MultipartFile multipartFile) throws IOException;

    byte[] getAlunoFile(Long id);

    List<Aluno> findAll();

}
