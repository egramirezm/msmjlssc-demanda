/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import mx.gob.imss.cit.mjlssc.model.request.RepresentanteDto;

/**
 * @author
 *
 */
public interface RepresentanteService {

	ResponseEntity<?> save(ArrayList<RepresentanteDto> lstDto);

}
