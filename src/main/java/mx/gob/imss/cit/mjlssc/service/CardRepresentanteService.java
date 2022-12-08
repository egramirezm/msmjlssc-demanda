/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.CardRepresentanteDto;

/**
 * @author
 *
 */
public interface CardRepresentanteService {

	ResponseEntity<?> save(CardRepresentanteDto cardRepresentanteDto);

}
