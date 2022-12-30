/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoDto;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsunto;

/**
 * 
 * @author lgarduno
 *
 */
public interface DemandaService {

	ResponseEntity<?> save(DemandaRegisRequestDto demandaRequestDto);

	List<MjltAsuntoDto> getDemanda(Integer numExpediente, Integer anioExpediente);

}
