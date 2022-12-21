/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;


/**
 * @author pacastillo
 *
 */
public interface AntecedentesService {

	ResponseEntity<?> getDetalleActor(Long id);

}
