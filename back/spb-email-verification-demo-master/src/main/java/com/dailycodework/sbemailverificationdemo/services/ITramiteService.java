package com.dailycodework.sbemailverificationdemo.services;



import java.util.List;

import com.dailycodework.sbemailverificationdemo.entities.Tramite;



public interface ITramiteService {
	List<Tramite> listTramite();
	Tramite registerTramite(Tramite tramite);
	Tramite tramiteById(Long id);
	Tramite updateTramite(Long id, Tramite tramite);
	boolean deleteTramite(Long id);
	
	
}
