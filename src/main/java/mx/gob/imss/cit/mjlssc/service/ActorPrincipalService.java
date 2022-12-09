/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.PersonaRequestDto;

/**
 * @author
 *
 */
public interface ActorPrincipalService {

	ResponseEntity<?> save(PersonaRequestDto dto);

}
