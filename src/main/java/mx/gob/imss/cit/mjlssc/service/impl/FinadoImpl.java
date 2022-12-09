/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.request.PersonaRequestDto;
import mx.gob.imss.cit.mjlssc.service.ActorPrincipalService;
import mx.gob.imss.cit.mjlssc.service.FinadoService;

/**
 * @author
 *
 */
@Log4j2
@Service
public class FinadoImpl implements FinadoService {
	
	@Autowired
	private ActorPrincipalService actorPrincipalService;

//	@Autowired
//	private DelegacionMapper delegacionMapper;
//
//	@Autowired
//	private SsccDelegacionRepository ssccDelegacionRepository;

	/*
	 * solo es prueba, revisar y definir uso de mappers y demas
	 */
	/**
	 * Save para el registro de la demanda
	 */
	@Override
	@Transactional
	public ResponseEntity<?> save(ArrayList<PersonaRequestDto> lstDto) {
		log.info("Inicio DelegacionService getDelegaciones");
		
		try {
			
//			actorPrincipalService.save(lstDto);
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
