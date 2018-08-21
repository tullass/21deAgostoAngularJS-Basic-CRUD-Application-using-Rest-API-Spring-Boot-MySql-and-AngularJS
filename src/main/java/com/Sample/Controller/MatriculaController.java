package com.Sample.Controller;

import java.util.ArrayList;
import java.util.List;

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
import com.Sample.Enum.Pronvicia;
import com.Sample.Service.AlunoService;
import com.Sample.Service.MatriculaService;
import com.Sample.Service.ProfessorService;
import com.Sample.Service.SemestreService;
import com.Sample.Service.TurmaService;

@RestController
@RequestMapping("matricula")
public class MatriculaController {

	@Autowired
	private MatriculaService alunoService;

	@Autowired
	private AlunoService aService;

	@Autowired
	private SemestreService semestreService;

	@Autowired
	private ProfessorService proService;

	@Autowired
	private TurmaService turmaService;

	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return alunoService.findAll();
	}
	
	@RequestMapping(value = "/listarAlunos", method = RequestMethod.GET)
	@ResponseBody
	public Object indexs() {
		return aService.findAll();
	}

	@RequestMapping(value = "/semestres", method = RequestMethod.GET)
	@ResponseBody
	public Object indehx() {
		return semestreService.findAll();
	}

	@RequestMapping(value = "/listarTurmas", method = RequestMethod.GET)
	@ResponseBody
	public Object tun() {
		return turmaService.findAll();
	}
	@RequestMapping(value = "/listarProf", method = RequestMethod.GET)
	@ResponseBody
	public Object tuns() {
		return proService.findAll();
	}

	@RequestMapping("/userr/pronvicia")
	public List<String> getPronvicia() {
		List<String> profiles = new ArrayList<>();
		for (Pronvicia profile : Pronvicia.values()) {
			profiles.add(profile.name());
		}
		return profiles;
	}
	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Matricula p = alunoService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Matricula areaa) {
		alunoService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Matricula aluno) {
		alunoService.save(aluno);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	
}
