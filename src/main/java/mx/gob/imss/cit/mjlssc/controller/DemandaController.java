/**
 * 
 */
package mx.gob.imss.cit.mjlssc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.service.DemandaService;

/***
 * 
 * @author
 *
 */
@Log4j2
@RestController
public class DemandaController {

	@Autowired
	private DemandaService demandaService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody DemandaRegisRequestDto requestDto) {
		log.info("--->> Save registro de la demanda: " + requestDto);
//		return demandaService.save(requestDto);
		return null;
	}

}
