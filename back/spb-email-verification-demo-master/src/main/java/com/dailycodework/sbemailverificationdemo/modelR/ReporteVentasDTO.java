package com.dailycodework.sbemailverificationdemo.modelR;



import java.io.ByteArrayInputStream;
import java.util.Date;

public class ReporteVentasDTO {

	private String fileName;
	private Date fechaGeneracion;
	private ByteArrayInputStream stream;
	private int length;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public ByteArrayInputStream getStream() {
		return stream;
	}

	public void setStream(ByteArrayInputStream stream) {
		this.stream = stream;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
