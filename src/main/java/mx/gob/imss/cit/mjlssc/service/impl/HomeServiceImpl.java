/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.response.HomeJuicioLaboralResponseDto;
import mx.gob.imss.cit.mjlssc.persistence.repository.HomeJuicioLaboralRepository;
import mx.gob.imss.cit.mjlssc.service.HomeService;
import mx.gob.imss.cit.nmlssc.support.model.PageModel;

/**
 * @author
 *
 */
@Log4j2
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeJuicioLaboralRepository homeJuicioLaboralRepository;

	@Value("${nml.schema}")
	private String esquemaNml;

	@Override
	public Object getHomeJuicioLaboral(String nombre, Integer folio, Integer anio, Integer cveEdoProcesal,Pageable pageable) {
		log.info("Inicio home juico Laboral");
		PageModel<HomeJuicioLaboralResponseDto> home = null;
		try {
			home = homeJuicioLaboralRepository.getHomeJuicoLaboral(nombre, folio, anio, cveEdoProcesal, esquemaNml,pageable);
		} catch (Exception e) {
			log.error("error getHomeJuicioLaboral", e);
			new ResponseEntity<>(home, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return home;
	}

}
