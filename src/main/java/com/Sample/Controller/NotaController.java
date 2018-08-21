package com.Sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.Entity.Matricula;
import com.Sample.Entity.Nota;
import com.Sample.Service.MatriculaService;
import com.Sample.Service.NotaService;
import com.Sample.Service.ProfessorService;
import com.Sample.Service.SemestreService;

@RestController
@RequestMapping("nota")
public class NotaController {

	@Autowired
	private NotaService alunoService;

	@Autowired
	private MatriculaService aService;

	@Autowired
	private SemestreService sService;

	@Autowired
	private ProfessorService tService;

	@RequestMapping(value = "/notalistar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return alunoService.findAll();
	}

	@RequestMapping(value = "/listarSems", method = RequestMethod.GET)
	@ResponseBody
	public Object indeSx() {
		return sService.findAll();
	}

	@RequestMapping(value = "/listarTurmas", method = RequestMethod.GET)
	@ResponseBody
	public Object indSex() {
		return tService.findAll();
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object indexs() {
		return aService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Nota areaa) {
		alunoService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Nota aluno) {
		alunoService.save(aluno);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Matricula p = aService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
