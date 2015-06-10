package ar.gov.santafe.meduc.lce.dao.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import modelo.organismos.Pais;
import modelo.personas.Persona;
import ar.com.norrmann.remote.interfaces.GenericDao;

@Named
@Path("/test")
public class TestController {
	
	@Inject
	GenericDao<Persona> personaDao;

	@Inject
	GenericDao<Pais> paisDao;
	
	@GET
	@Produces("text/html")
	@Path("/{id}")
	public String test(@PathParam("id") Long id){
		
		return "hola "+personaDao.find(id).getApellidoSoltero()+ " pais "+paisDao.find(id).getPais();
	}

}
