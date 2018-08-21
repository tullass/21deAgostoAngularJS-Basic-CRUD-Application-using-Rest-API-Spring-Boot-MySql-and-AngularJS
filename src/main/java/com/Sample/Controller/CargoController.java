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

import com.Sample.Entity.Cargos;
import com.Sample.Service.CargoService;

@RestController
@RequestMapping("cargo")
public class CargoController {

	@Autowired
	private CargoService alunoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return alunoService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Cargos areaa) {
		alunoService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Cargos aluno) {
		alunoService.save(aluno);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Cargos p = alunoService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
