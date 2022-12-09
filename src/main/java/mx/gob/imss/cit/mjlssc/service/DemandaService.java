/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;

/**
 * 
 * @author lgarduno
 *
 */
public interface DemandaService {

	ResponseEntity<?> save(DemandaRegisRequestDto demandaRequestDto);

}
