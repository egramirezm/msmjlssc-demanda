/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.ConfIndiSeguSocRequestDto;

/**
 * @author
 *
 */
public interface ConflictoIndividualSeguridadSocialService {

	ResponseEntity<?> save(ConfIndiSeguSocRequestDto dto);

}
