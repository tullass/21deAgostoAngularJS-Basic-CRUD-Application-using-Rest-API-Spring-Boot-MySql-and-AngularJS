package com.Sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.Entity.Semestre;
import com.Sample.Service.DisciplinaService;
import com.Sample.Service.SemestreService;

@RestController
@RequestMapping("semestre")
public class SemestreController {

	@Autowired
	private SemestreService semestreService;

	@Autowired
	private DisciplinaService disciplinaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return semestreService.findAll();
	}
	@RequestMapping(value = "/listaDisciplina", method = RequestMethod.GET)
	@ResponseBody
	public Object indexs() {
		return disciplinaService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Semestre areaa) {
		semestreService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Semestre semestre) {
		semestreService.save(semestre);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
