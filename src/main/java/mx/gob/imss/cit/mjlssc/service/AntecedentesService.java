/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service;

import java.util.List;

import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoActorDto;


/**
 * @author pacastillo
 *
 */
public interface AntecedentesService {

	List<MjltAsuntoActorDto> getDetalleActor();

	MjltAsuntoActorDto getDetalleActorByCveAsutoActor(Integer cveAsutoActor);

}
