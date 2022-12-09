/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.AccionesReclamadasDto;

/**
 * @author
 *
 */
public interface AccionesReclamadasService {

	ResponseEntity<?> save(AccionesReclamadasDto cardAccionesReclamadaso);

}
