/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.CardAccionesReclamadasDto;
import mx.gob.imss.cit.mjlssc.model.entity.CardDatosJuicioDto;
import mx.gob.imss.cit.mjlssc.service.CardAccionesReclamadasService;

/**
 * @author
 *
 */
@Log4j2
@Service
public class CardAccionesReclamadasImpl implements CardAccionesReclamadasService {

//	@Autowired
//	private DelegacionMapper delegacionMapper;
//
//	@Autowired
//	private SsccDelegacionRepository ssccDelegacionRepository;

	/*
	 * solo prueba revisar y definir uso de mappers y demas
	 */
	@Override
	public ResponseEntity<?> save(CardAccionesReclamadasDto accionesReclamadasDto) {
		log.info("Inicio DelegacionService getDelegaciones");
		
		try {
			// ejemplo projection
			//SsccDelegacionView delegacionProjection = ssccDelegacionRepository.findByRefAbreviacion("DFS",SsccDelegacionView.class);
//			DatosJuicioDto datosJuicio = ssccDelegacionRepository.findAll();
			// delegacionDtos = ObjectMapperUtils.mapAll(delegaciones,SsccDelegacionDto.class);
//			delegacionDtos = delegacionMapper.toLstDto(delegaciones);
		} catch (Exception e) {
			log.error("Exception DatosJuicioImpl saveDatosJuicio", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		return new ResponseEntity<>(datosJuicio, HttpStatus.OK);
		return null;
	}


}
