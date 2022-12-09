/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.PersonaRequestDto;

/**
 * @author
 *
 */
public interface FinadoService {

	ResponseEntity<?> save(ArrayList<PersonaRequestDto> lstDto);

}
