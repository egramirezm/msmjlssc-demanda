/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.AbogadoResponsableDto;
import mx.gob.imss.cit.mjlssc.model.request.DatosJuicioDto;

/**
 * @author
 *
 */
public interface AbogadoResponsableService {

	ResponseEntity<?> save(AbogadoResponsableDto cartAbogadoResponsableDto);

}
