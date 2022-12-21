/**
 * 
 */
package mx.gob.imss.cit.mjlssc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.service.AntecedentesService;
import mx.gob.imss.cit.mjlssc.service.DemandaService;


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

	@PostMapping("detalleActor/{id}")
	public ResponseEntity<?> getDetalleActor(@PathVariable Long id) {
		log.info("--->> getDetalleActor::id:" + id);
		return antecedentesService.getDetalleActor(id);
	}

}
