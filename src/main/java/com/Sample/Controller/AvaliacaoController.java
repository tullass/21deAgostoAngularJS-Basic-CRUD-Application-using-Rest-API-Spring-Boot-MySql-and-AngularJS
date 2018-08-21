package com.Sample.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

import com.Sample.Entity.Avaliacoes;
import com.Sample.Service.AvaliacaoesService;
import com.Sample.Service.MatriculaService;
import com.Sample.Service.ProfessorService;
import com.Sample.Service.SemestreService;
import com.Sample.Service.TurmaService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoesService semestreService;

	@Autowired
	private TurmaService disciplinaService;

	@Autowired
	private ProfessorService pService;

	@Autowired
	private SemestreService tService;

	@Autowired
	private MatriculaService mService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return semestreService.findAll();
	}

	@RequestMapping(value = "/listaProf", method = RequestMethod.GET)
	@ResponseBody
	public Object indwesxs() {
		return pService.findAll();
	}

	@RequestMapping(value = "/listaTurma", method = RequestMethod.GET)
	@ResponseBody
	public Object indexas() {
		return disciplinaService.findAll();
	}

	@RequestMapping(value = "/listaTrimestre", method = RequestMethod.GET)
	@ResponseBody
	public Object indexss() {
		return tService.findAll();
	}

	@RequestMapping(value = "/listaTodos", method = RequestMethod.GET)
	@ResponseBody
	public Object indwexs() {
		return mService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Avaliacoes areaa) {
		semestreService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Avaliacoes semestre) {
		semestreService.save(semestre);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@GetMapping(path = "ab/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		List<Avaliacoes> p = semestreService.innerJ(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> sdhsj(@PathVariable("id") Long id) {
		Avaliacoes p = semestreService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public @ResponseBody void reportXLS(@PathVariable("id") Long id,HttpServletResponse response) {
		Long s = semestreService.findById
				(id).getId().longValue();
		try {

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/avalia.jrxml");
			JasperDesign desing = JRXmlLoader.load(jasperStream);

			JasperReport report = JasperCompileManager.compileReport(desing);

			Map<String, Object> parametermap = new HashMap<String, Object>();
			List<Avaliacoes> carros = semestreService.innerJ(s);
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(carros);
			parametermap.put("datasource", jrDataSource);

			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametermap, jrDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Disposition", "inline; filename=certificado.pdf");

			final OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		} catch (IOException e) {
			System.out.println("erro IO " + e.getMessage());

			e.printStackTrace();
		} catch (JRException e) {
			System.out.println("erro JR " + e.getMessage());
			e.printStackTrace();

		}

	}
}
