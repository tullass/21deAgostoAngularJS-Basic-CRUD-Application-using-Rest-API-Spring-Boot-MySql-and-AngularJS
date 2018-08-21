package com.Sample.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.Entity.Fatura;
import com.Sample.Service.FaturaService;
import com.Sample.Service.MatriculaService;

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
@RequestMapping("extrato")
public class ExtratoController {

	@Autowired
	private FaturaService faturaService;

	@Autowired
	private MatriculaService mService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return mService.findAll();
	}

	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public @ResponseBody void reportXLS(@PathVariable("id") Long id, HttpServletResponse response) {
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
			// TODO Auto-generated catch block
			System.out.println("erro IO " + e.getMessage());

			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			System.out.println("erro JR " + e.getMessage());
			e.printStackTrace();

		}

	}
}
