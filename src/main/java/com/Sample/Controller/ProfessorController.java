package com.Sample.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.Entity.Professor;
import com.Sample.Enum.Pronvicia;
import com.Sample.Service.CargoService;
import com.Sample.Service.DisciplinaService;
import com.Sample.Service.MatriculaService;
import com.Sample.Service.ProfessorService;
import com.Sample.Service.TurmaService;

@RestController
@RequestMapping("professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private DisciplinaService disciplinaService;

	@Autowired
	private TurmaService turmaaService;

	@Autowired
	private MatriculaService aService;
	
	@Autowired
	private CargoService cService;

	@RequestMapping(value = "/listarAl", method = RequestMethod.GET)
	@ResponseBody
	public Object indexs() {
		return aService.findAll();
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return professorService.findAll();
	}
	
	@RequestMapping(value = "/cargoos", method = RequestMethod.GET)
	@ResponseBody
	public Object inddex() {
		return cService.findAll();
	}

	@RequestMapping(value = "/listardisciplinas", method = RequestMethod.GET)
	@ResponseBody
	public Object indexd() {
		return disciplinaService.findAll();
	}
	@RequestMapping(value = "/listarturmas", method = RequestMethod.GET)
	@ResponseBody
	public Object indexsd() {
		return turmaaService.findAll();
	}

	
	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Professor p = professorService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Professor areaa) {
		professorService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Professor professor) {
		professorService.save(professor);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		professorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/pronvicias")
	public List<String> getPronvicia() {
		List<String> profiles = new ArrayList<>();
		for (Pronvicia profile : Pronvicia.values()) {
			profiles.add(profile.name());
		}
		return profiles;
	}
//	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
//	public @ResponseBody void reportXLS(@PathVariable("id") Long id,HttpServletResponse response) {
//		Long s = faturaService.findById(id).getId().longValue();
//		try {
//
//			InputStream jasperStream = this.getClass().getResourceAsStream("/report/aluno.jrxml");
//			JasperDesign desing = JRXmlLoader.load(jasperStream);
//
//			JasperReport report = JasperCompileManager.compileReport(desing);
//
//			Map<String, Object> parametermap = new HashMap<String, Object>();
//			List<Fatura> carros = faturaService.innerJ(s);
//			JRDataSource jrDataSource = new JRBeanCollectionDataSource(carros);
//			parametermap.put("datasource", jrDataSource);
//
//			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametermap, jrDataSource);
//			response.setContentType("application/x-pdf");
//			response.setHeader("Content-Disposition", "inline; filename=aluno.pdf");
//
//			final OutputStream outputStream = response.getOutputStream();
//			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("erro IO " + e.getMessage());
//
//			e.printStackTrace();
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			System.out.println("erro JR " + e.getMessage());
//			e.printStackTrace();
//
//		}
//
//	}

}
