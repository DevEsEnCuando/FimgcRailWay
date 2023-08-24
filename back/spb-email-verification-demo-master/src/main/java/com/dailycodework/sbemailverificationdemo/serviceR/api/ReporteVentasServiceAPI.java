package com.dailycodework.sbemailverificationdemo.serviceR.api;



import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.dailycodework.sbemailverificationdemo.modelR.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentasServiceAPI {
	
	ReporteVentasDTO obtenerMemorandoPlan(Map<String, Object> params) throws JRException, IOException, SQLException;
	ReporteVentasDTO obtenerMemorandoBachiller(Map<String, Object> params) throws JRException, IOException, SQLException;
	ReporteVentasDTO obtenerMemorandoTitulo(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	
	ReporteVentasDTO obtenerResolucionPlan(Map<String, Object> params) throws JRException, IOException, SQLException;
	ReporteVentasDTO obtenerResolucionBorrador(Map<String, Object> params) throws JRException, IOException, SQLException;
	ReporteVentasDTO obtenerResolucionBachiller(Map<String, Object> params) throws JRException, IOException, SQLException;
	ReporteVentasDTO obtenerResolucionTitulo(Map<String, Object> params) throws JRException, IOException, SQLException;

}
