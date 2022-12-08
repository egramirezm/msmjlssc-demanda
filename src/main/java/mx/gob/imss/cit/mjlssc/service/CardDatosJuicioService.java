/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.CardDatosJuicioDto;

/**
 * @author
 *
 */
public interface CardDatosJuicioService {

	ResponseEntity<?> save(CardDatosJuicioDto datosJuicio);

}
