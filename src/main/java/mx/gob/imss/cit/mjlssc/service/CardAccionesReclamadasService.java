/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.CardAccionesReclamadasDto;

/**
 * @author
 *
 */
public interface CardAccionesReclamadasService {

	ResponseEntity<?> save(CardAccionesReclamadasDto cardAccionesReclamadaso);

}
