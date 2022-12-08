/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.entity.CardDatosJuicioDto;
import mx.gob.imss.cit.mjlssc.model.entity.CardAbogadoResponsableDto;

/**
 * @author
 *
 */
public interface CardAbogadoResponsableService {

	ResponseEntity<?> save(CardAbogadoResponsableDto cartAbogadoResponsableDto);

}
