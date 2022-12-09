/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.assembler.DelegacionMapper;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.persistence.repository.SsccDelegacionRepository;
import mx.gob.imss.cit.mjlssc.service.AccionesReclamadasService;
import mx.gob.imss.cit.mjlssc.service.ActorPrincipalService;
import mx.gob.imss.cit.mjlssc.service.ConflictoIndividualSeguridadSocialService;
import mx.gob.imss.cit.mjlssc.service.DatosJuicioService;
import mx.gob.imss.cit.mjlssc.service.DemandaService;
import mx.gob.imss.cit.mjlssc.service.FinadoService;
import mx.gob.imss.cit.mjlssc.service.RepresentanteService;

/**
 * @author
 *
 */
@Log4j2
@Service
public class DemandaImpl implements DemandaService {

	@Autowired
	private ActorPrincipalService actorPrincipalService;

	@Autowired
	private ConflictoIndividualSeguridadSocialService conflictoIndividualSeguridadSocialService;
	
	@Autowired
	private FinadoService finadoService;
	
	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private AccionesReclamadasService accionesReclamadasService; 
	
	@Autowired
	private DatosJuicioService datosJuicioService;

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
	public ResponseEntity<?> save(DemandaRegisRequestDto demandaRequestDto) {
		log.info("Inicio DelegacionService getDelegaciones");

		try {
			// FIXME Falta invocar el repo de demanda para la persistencia 
			
			log.info("NOTA REPOSITORY DEMANDA " + demandaRequestDto.getCardDemanda());
			actorPrincipalService.save(demandaRequestDto.getCardActorPrincipal());
			conflictoIndividualSeguridadSocialService
					.save(demandaRequestDto.getCardConflictoIndividualSeguridadSocial());
			finadoService.save(demandaRequestDto.getCardFinado());
			
			representanteService.save(demandaRequestDto.getCardRepresentante());
			
			accionesReclamadasService.save(demandaRequestDto.getCardAccionesReclamadas());
			
			datosJuicioService.save(demandaRequestDto.getCardDatosJuicio());

			// ejemplo projection
			// SsccDelegacionView delegacionProjection =
			// ssccDelegacionRepository.findByRefAbreviacion("DFS",SsccDelegacionView.class);
//			DatosJuicioDto datosJuicio = ssccDelegacionRepository.findAll();
			// delegacionDtos =
			// ObjectMapperUtils.mapAll(delegaciones,SsccDelegacionDto.class);
//			delegacionDtos = delegacionMapper.toLstDto(delegaciones);
		} catch (Exception e) {
			log.error("Exception DatosJuicioImpl saveDatosJuicio", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		return new ResponseEntity<>(datosJuicio, HttpStatus.OK);
		return null;
	}

}
