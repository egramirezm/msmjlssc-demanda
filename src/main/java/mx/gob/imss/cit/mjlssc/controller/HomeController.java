/**
 * 
 */
package mx.gob.imss.cit.mjlssc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.service.HomeService;

/***
 * 
 * @author
 *
 */
@Log4j2
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private HomeService homeService;

	@GetMapping("/juicioLaboral")
	public ResponseEntity<?> prueba(Pageable pageable, @RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "folio", required = false) Integer folio,
			@RequestParam(value = "anio", required = false) Integer anio,
			@RequestParam(value = "cveEdoProcesal", required = false) Integer cveEdoProcesal) {
		log.info("Inicio home juicoLaboral");
		return new ResponseEntity<>(homeService.getHomeJuicioLaboral(nombre, folio, anio, cveEdoProcesal, pageable),HttpStatus.OK);
	}

}
