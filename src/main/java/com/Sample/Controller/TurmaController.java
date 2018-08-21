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

import com.Sample.Entity.Turma;
import com.Sample.Service.NivelService;
import com.Sample.Service.TurmaService;

@RestController
@RequestMapping("turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private NivelService classeService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return turmaService.findAll();
	}

	@RequestMapping(value = "/listarClasses", method = RequestMethod.GET)
	@ResponseBody
	public Object ListarClasse() {
		return classeService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Turma areaa) {
		turmaService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Turma turma) {
		turmaService.save(turma);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Turma p = turmaService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
