/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.service.AntecedentesService;

/**
 * @author
 *
 */
@Log4j2
@Service
public class AntecedentesServiceImpl implements AntecedentesService {

	
	@Override
	@Transactional
	public ResponseEntity<?> getDetalleActor(Long id) {
		log.info("Inicio getDetalleActor");

		try {
			
			
		} catch (Exception e) {
			log.error("Exception DatosJuicioImpl saveDatosJuicio", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		return new ResponseEntity<>(datosJuicio, HttpStatus.OK);
		return null;
	}

}
