/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.DatosJuicioDto;

/**
 * @author
 *
 */
public interface DatosJuicioService {

	ResponseEntity<?> save(DatosJuicioDto datosJuicio);

}
