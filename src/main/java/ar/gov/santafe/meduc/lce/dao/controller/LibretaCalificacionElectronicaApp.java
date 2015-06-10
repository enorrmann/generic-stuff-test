package ar.gov.santafe.meduc.lce.dao.controller;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
	
@ApplicationPath("/")
public class LibretaCalificacionElectronicaApp extends ResourceConfig {
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<Class<?>>();
//        s.add(PersonaDao.class);
//        s.add(LocalidadDao.class);
//        s.add(PaisDao.class);
//        s.add(ExceptionMapper.class);
//        
//        return s;
//    }
	public LibretaCalificacionElectronicaApp(){
		register(DeclarativeLinkingFeature.class);
        packages("ar.gov.santafe.meduc.lce.dao.controller");
        
	}
}
