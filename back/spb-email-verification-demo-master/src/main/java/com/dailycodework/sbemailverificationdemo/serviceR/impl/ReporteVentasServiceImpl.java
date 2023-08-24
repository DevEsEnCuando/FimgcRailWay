package com.dailycodework.sbemailverificationdemo.serviceR.impl;





import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.commonsR.JasperReportManager;
import com.dailycodework.sbemailverificationdemo.entities.Documento;
import com.dailycodework.sbemailverificationdemo.enumsR.TipoReporteEnum;
import com.dailycodework.sbemailverificationdemo.modelR.ReporteVentasDTO;
import com.dailycodework.sbemailverificationdemo.repositories.IDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.serviceR.api.ReporteVentasServiceAPI;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteVentasServiceImpl implements ReporteVentasServiceAPI {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;
	
	@Autowired
    private IDocumentoRepository documentoRepository; // Suponiendo que tienes un repositorio para la entidad Documento


	@Override
	public ReporteVentasDTO obtenerMemorandoPlan(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),1L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="MM";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/MM/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Revision Plan de Tesis"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
	
	@Override
	public ReporteVentasDTO obtenerMemorandoBachiller(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),1L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="MMBachiller";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/MM/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Revision Bachiller"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
	
	@Override
	public ReporteVentasDTO obtenerMemorandoTitulo(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),1L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="MMTitulo";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/MM/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Revision Titulo"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
	
	@Override
	public ReporteVentasDTO obtenerResolucionPlan(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),3L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="RDPlan";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/RDPlan/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Aprobación Plan de Tesis"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
	
	@Override
	public ReporteVentasDTO obtenerResolucionBorrador(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),3L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="RDBorrador";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/RDBorrador/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Aprobación Borrador de Tesis"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
	
	@Override
	public ReporteVentasDTO obtenerResolucionBachiller(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),3L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="RCFBachiller";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/RCFBachiller/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Grado Bachiller"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}

	@Override
	public ReporteVentasDTO obtenerResolucionTitulo(Map<String, Object> params)
			throws JRException, IOException, SQLException { 
	
		
		//------------------------------- ACTUALIZANDO FECHA DE GENERACIÓN EN BASE DE DATOS
		Documento odocumento = documentoRepository.findByNroExpediente(params.get("NroExp").toString(),3L);
		odocumento.setFechaGeneracion(new Date()); // Establecer la fecha actual
		odocumento = documentoRepository.save(odocumento);		
		
		String fileName="RCFTitulo";
		ReporteVentasDTO dto = new ReporteVentasDTO();        
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx": ".pdf";
		dto.setFileName(fileName + extension);

		// Ruta donde guardarás los archivos PDF en el sistema de archivos (ajústalo según tu configuración)
		String pdfFilePath = "documentos/RCFTitulo/" + fileName +" Nº "+odocumento.getNumeroDocumento()+"-2023 Titulo Profesional"+ extension;
		
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		

		// Guardar el archivo PDF en el sistema de archivos
		Files.write(Paths.get(pdfFilePath), bs);

		// Actualizar la columna 'archivopdfsf' con el nombre del archivo en la base de datos
		odocumento.setArchivopdfSF(fileName);		
		
		odocumento = documentoRepository.save(odocumento);
		
	

		return dto;
	}
}
