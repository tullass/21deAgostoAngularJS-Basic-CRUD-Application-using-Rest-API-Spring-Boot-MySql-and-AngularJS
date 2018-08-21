package com.Sample.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import com.Sample.Entity.Fatura;
import com.Sample.Service.BancoService;
import com.Sample.Service.CargoService;
import com.Sample.Service.FaturaService;
import com.Sample.Service.MatriculaService;
import com.Sample.Service.NivelService;
import com.Sample.Service.ProfessorService;
import com.Sample.Service.TipoService;
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
@RequestMapping("fatura")
public class FaturaController {

	@Autowired
	private FaturaService faturaService;
	@Autowired
	private ProfessorService profService;

	@Autowired
	private TipoService tipoService;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private NivelService classeService;

	@Autowired
	private MatriculaService alunoService;

	@Autowired
	private CargoService cService;

	@Autowired
	private BancoService bancoService;

	@RequestMapping(value = "/listarB", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listA(Pageable p) {
		return new ResponseEntity<>(faturaService.findByNome(p), HttpStatus.OK);
	}

	@RequestMapping(value = "/cargoos", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listdA() {
		return new ResponseEntity<>(cService.findAll(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/inn", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<?> lisdastA(@PathVariable("id") Long id) {
//		return new ResponseEntity<>(faturaService.innerJ(id), HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/listarAll", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listsssA( ) {
		return new ResponseEntity<>(faturaService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pagouu", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> liedxssA( ) {
		return new ResponseEntity<>(faturaService.PagouSalaries(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/prof", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> lisA( ) {
		return new ResponseEntity<>(profService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> liA( ) {
		return new ResponseEntity<>(faturaService.Pendentess(), HttpStatus.OK);
	}
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> litodpA( ) {
		return new ResponseEntity<>(faturaService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/avg", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listss() {
		return new ResponseEntity<>(faturaService.avg(), HttpStatus.OK);
	}
	@RequestMapping(value = "/o", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listsds() {
		return new ResponseEntity<>(faturaService.findBy(), HttpStatus.OK);
	}

	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listsA() {
		return new ResponseEntity<>(classeService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/turmas", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listA() {
		return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return faturaService.findAll();
	}

//	@RequestMapping(value = "/listarBoolean", method = RequestMethod.GET)
//	@ResponseBody
//	public Object indexs() {
//		return faturaService.Querry();
//	}
//
//	@RequestMapping(value = "/listarAtivos", method = RequestMethod.GET)
//	@ResponseBody
//	public Object indesx() {
//		return faturaService.findByAdiantamentos(true);
//	}

	@RequestMapping(value = "/listarBanco", method = RequestMethod.GET)
	@ResponseBody
	public Object indexss() {
		return bancoService.findAll();
	}

	@RequestMapping(value = "/listarTipo", method = RequestMethod.GET)
	@ResponseBody
	public Object indexx() {
		return tipoService.findAll();
	}

	@RequestMapping(value = "/listarAluno", method = RequestMethod.GET)
	@ResponseBody
	public Object indexxx() {
		return alunoService.findAll();
	}

	@RequestMapping(value = "/a", method = RequestMethod.POST)
	public ResponseEntity<?> creatde(@RequestBody Fatura areaa) {
		areaa.setAdiantamento(true);
		faturaService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Fatura areaa) {
		faturaService.save(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}

	@GetMapping(path = "aa/{id}")
	public ResponseEntity<?> hsj(@PathVariable("id") Long id) {
		Fatura p = faturaService.findById(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}


	
	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> teste(@PathVariable("id") Long id) {
		List<Fatura> p = faturaService.encotra(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updd(@RequestBody Fatura aluno) {
		faturaService.save(aluno);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public @ResponseBody void reportXLS(@PathVariable("id") Long id,HttpServletResponse response) {
		Long s = faturaService.findById(id).getId().longValue();
		try {

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/prou.jrxml");
			JasperDesign desing = JRXmlLoader.load(jasperStream);

			JasperReport report = JasperCompileManager.compileReport(desing);

			Map<String, Object> parametermap = new HashMap<String, Object>();
			List<Fatura> carros = faturaService.innerP(s);
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(carros);
			parametermap.put("datasource", jrDataSource);

			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametermap, jrDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Disposition", "inline; filename=salario.pdf");

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
