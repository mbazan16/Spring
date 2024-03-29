package com.sb.ln;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.RegionDAO;
import com.sb.entities.Region;
import com.sb.ln.exceptions.CodeException;
import com.sb.ln.exceptions.ServicioException;
import com.sb.ln.interfaces.IServicioRegion;


@Service
public class ServicioRegion implements IServicioRegion {

	private final static Logger log = LoggerFactory.getLogger(ServicioRegion.class);

	@Autowired
	RegionDAO dao;
	

	@Override
	public Iterable<Region> mostrarRegiones() throws ServicioException {
		log.info("mostrarRegiones");

		Iterable<Region> regiones = new ArrayList<Region>();

		try {
			regiones = dao.findAll();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServicioException(CodeException.EXEPCION_GENERAL);
		}
		return regiones;
	}
	@Override
	public void crearRegion(String nombre) throws ServicioException {
		log.info("crearRegion");
		log.debug("nombre:"+nombre);
		try {
			Region region = new Region();
			int id=0;
			for(Region regionAux:dao.findAll()) {
				if(id<regionAux.getId()) id=regionAux.getId();
			}
			region.setId(++id);
			region.setNombre(nombre);
			dao.save(region);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ServicioException(CodeException.EXEPCION_GENERAL);
		}

	}

}
