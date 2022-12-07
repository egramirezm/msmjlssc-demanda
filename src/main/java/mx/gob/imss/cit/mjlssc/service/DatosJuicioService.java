/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.DatosJuicioDto;

/**
 * @author
 *
 */
public interface DatosJuicioService {

	ResponseEntity<?> saveDatosJuicio(DatosJuicioDto datosJuicio);

}
