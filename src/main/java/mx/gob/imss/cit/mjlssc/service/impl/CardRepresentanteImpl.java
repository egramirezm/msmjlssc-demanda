/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.CardRepresentanteDto;
import mx.gob.imss.cit.mjlssc.service.CardRepresentanteService;

/**
 * @author
 *
 */
@Log4j2
@Service
public class CardRepresentanteImpl implements CardRepresentanteService {


	/*
	 * solo prueba revisar y definir uso de mappers y demas
	 */
	@Override
	public ResponseEntity<?> save(CardRepresentanteDto cardRepresentanteDto  ) {
		log.info("Inicio CartAbogadoResponsableImpl");
		
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
