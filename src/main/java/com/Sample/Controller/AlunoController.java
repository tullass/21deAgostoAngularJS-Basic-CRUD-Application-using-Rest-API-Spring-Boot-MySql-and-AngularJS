package com.Sample.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Sample.Entity.Aluno;
import com.Sample.Entity.Fatura;
import com.Sample.Service.AlunoService;
import com.Sample.Service.FaturaService;
import com.Sample.Service.ResponseMetadata;

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

@Controller
@RequestMapping(value = "/doc")
public class AlunoController {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AlunoController.class);

	@Autowired
	private AlunoService documentService;

	@Autowired
	private FaturaService faturaService;

	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseMetadata handleFileUpload(@RequestParam(value = "file") MultipartFile file)
			throws IOException {

		return documentService.save(file);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listA() {
		return new ResponseEntity<>(documentService.findAll(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/desc", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<?> lisdsdtA() {
//		return new ResponseEntity<>(faturaService.asc(), HttpStatus.OK);
//	}
//	
	@GetMapping(path = "a/{id}")
	public ResponseEntity<?> teste(@PathVariable("id") Long id) {
		List<Fatura> p = faturaService.innerJ(id);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public @ResponseBody void reportXLS(@PathVariable("id") Long id,HttpServletResponse response) {
		Long s = faturaService.findById(id).getId().longValue();
		try {

			InputStream jasperStream = this.getClass().getResourceAsStream("/report/aluno.jrxml");
			JasperDesign desing = JRXmlLoader.load(jasperStream);

			JasperReport report = JasperCompileManager.compileReport(desing);

			Map<String, Object> parametermap = new HashMap<String, Object>();
			List<Fatura> carros = faturaService.innerJ(s);
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(carros);
			parametermap.put("datasource", jrDataSource);

			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametermap, jrDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Disposition", "inline; filename=aluno.pdf");

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

	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public HttpEntity<byte[]> getAluno(@PathVariable Long id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		httpHeaders.setContentType(MediaType.APPLICATION_PDF);

		return new ResponseEntity<byte[]>(documentService.getAlunoFile(id), httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Aluno> getAluno() {
		return documentService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Aluno areaa) {
		documentService.saves(areaa);
		return new ResponseEntity<>(areaa, HttpStatus.OK);
	}
}
