package ar.gov.santafe.meduc.lce.dao.util;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ar.com.norrmann.remote.interfaces.GenericDao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@ApplicationScoped
public class ProductorUtil {

	@PersistenceContext(unitName = "SigaeEJBPU")
	private EntityManager em;

	@Produces
	public Gson getGsonParser() {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gsonObj = b.create();
		return gsonObj;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	@Produces
	public <T> GenericDao<T> getDao(InjectionPoint p) { 
		Class clazz = null;
		if (((ParameterizedType) p.getType()).getActualTypeArguments()[0] instanceof Class){
			clazz = (Class) ((ParameterizedType) p.getType()).getActualTypeArguments()[0];
		}
		return new GenericDao(clazz,em);
	}
}
