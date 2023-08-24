package com.dailycodework.sbemailverificationdemo.controllerR;



import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.enumsR.TipoReporteEnum;
import com.dailycodework.sbemailverificationdemo.modelR.ReporteVentasDTO;
import com.dailycodework.sbemailverificationdemo.serviceR.api.ReporteVentasServiceAPI;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/reporte")
public class ReporteVentasController {

	@Autowired
	private ReporteVentasServiceAPI reporteVentasServiceAPI;

	@GetMapping(path = "/MM/download")
	public ResponseEntity<Resource> downloadMemorando(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerMemorandoPlan(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/MMBachiller/download")
	public ResponseEntity<Resource> downloadMemorandoB(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerMemorandoBachiller(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/MMTitulo/download")
	public ResponseEntity<Resource> downloadMemorandoT(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerMemorandoTitulo(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/RDPlan/download")
	public ResponseEntity<Resource> downloadResolucionP(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerResolucionPlan(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/RDBorrador/download")
	public ResponseEntity<Resource> downloadResolucionB(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerResolucionBorrador(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/RCFBachiller/download")
	public ResponseEntity<Resource> downloadResolucionBach(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerResolucionBachiller(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/RCFTitulo/download")
	public ResponseEntity<Resource> downloadResolucionT(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteVentasDTO dto = reporteVentasServiceAPI.obtenerResolucionTitulo(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}

}
