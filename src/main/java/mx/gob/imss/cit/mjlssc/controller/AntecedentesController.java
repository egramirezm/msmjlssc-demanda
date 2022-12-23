/**
 * 
 */
package mx.gob.imss.cit.mjlssc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoActorDto;
import mx.gob.imss.cit.mjlssc.model.entity.ResponseDataDTO;
import mx.gob.imss.cit.mjlssc.service.AntecedentesService;
import mx.gob.imss.cit.mjlssc.utils.Constantes;


/**
 * @author pacastillo
 *
 */
@Log4j2
@RestController
@RequestMapping("/antecedentes")
public class AntecedentesController {

	@Autowired
	private AntecedentesService antecedentesService;

	@GetMapping("/detalleActor")
	public ResponseEntity<?> getDetalleActor() {
		log.info("--->> getDetalleActor" );
		try {
			List<MjltAsuntoActorDto> resultList = antecedentesService.getDetalleActor();
			if(!resultList.isEmpty()) {
				ResponseDataDTO<List<MjltAsuntoActorDto>> response = new ResponseDataDTO<>(Constantes.STATUS_200, Constantes.OK, resultList);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				ResponseDataDTO<List<MjltAsuntoActorDto>> response = new ResponseDataDTO<>(Constantes.STATUS_204, Constantes.NO_CONTENT, resultList);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			ResponseDataDTO<List<MjltAsuntoActorDto>> response = new ResponseDataDTO<>(Constantes.STATUS_500, Constantes.INTERNAL_SERVER_ERROR.concat(e.toString()), null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/detalleActor/{cveAsutoActor}")
	public ResponseEntity<?> getDetalleActorByCveAsutoActor(@PathVariable Integer cveAsutoActor) {
		log.info("--->> getDetalleActorByCveAsutoActor::cveAsutoActor:{}", cveAsutoActor );
		try {
			MjltAsuntoActorDto result = antecedentesService.getDetalleActorByCveAsutoActor(cveAsutoActor);
			if(result instanceof MjltAsuntoActorDto) {
				ResponseDataDTO<MjltAsuntoActorDto> response = new ResponseDataDTO<>(Constantes.STATUS_200, Constantes.OK, result);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				ResponseDataDTO<MjltAsuntoActorDto> response = new ResponseDataDTO<>(Constantes.STATUS_204, Constantes.NO_CONTENT, result);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			ResponseDataDTO<MjltAsuntoActorDto> response = new ResponseDataDTO<>(Constantes.STATUS_500, Constantes.INTERNAL_SERVER_ERROR.concat(e.toString()), null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
