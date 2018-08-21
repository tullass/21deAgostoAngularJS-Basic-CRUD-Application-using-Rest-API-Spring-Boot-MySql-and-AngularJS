package com.Sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.repository.AlunoRepository;
import com.Sample.repository.MatriculaRepository;
import com.Sample.repository.TurmaRepository;


@RestController
@RequestMapping("gen")
public class GenericController {

	
	@Autowired
	private AlunoRepository aa;

	@Autowired
	private TurmaRepository tt;

	@Autowired
	private MatriculaRepository mm;

	
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listssA() {
		return new ResponseEntity<>(+ aa.count(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/t", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listssasA() {
		return new ResponseEntity<>(+ tt.count(), HttpStatus.OK);
	}

	@RequestMapping(value = "/m", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listdfssA() {
		return new ResponseEntity<>(+ mm.count(), HttpStatus.OK);
	}

}
