/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsunto;
import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsuntoActor;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccCentroConciliacion;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccColoniaCp;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccSexo;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccTrascendencia;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccUmf;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccUsuario;
import mx.gob.imss.cit.mjlssc.persistence.repository.MjltAsuntoActorRepository;
import mx.gob.imss.cit.mjlssc.service.AccionesReclamadasService;
import mx.gob.imss.cit.mjlssc.service.ActorPrincipalService;
import mx.gob.imss.cit.mjlssc.service.ConflictoIndividualSeguridadSocialService;
import mx.gob.imss.cit.mjlssc.service.DatosJuicioService;
import mx.gob.imss.cit.mjlssc.service.DemandaService;
import mx.gob.imss.cit.mjlssc.service.FinadoService;
import mx.gob.imss.cit.mjlssc.service.RepresentanteService;
import mx.gob.imss.cit.mjlssc.utils.ObjectMapperUtils;

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

	@Autowired
	private MjltAsuntoActorRepository mjltAsuntoActorRepository;

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
			MjltAsunto mjltAsunto = new MjltAsunto();
			mjltAsunto.setId(demandaRequestDto.getCveAsunto());
			
			
			//Demanda
			SsccCentroConciliacion ssccCentroConciliacion = new SsccCentroConciliacion();
			ssccCentroConciliacion.setId(demandaRequestDto.getCardDemanda().getJuntaId());
			mjltAsunto.setCveJuntaConciliacion(ssccCentroConciliacion);
			mjltAsunto.setNumExpediente(demandaRequestDto.getCardDemanda().getNumeroExpediente());
			mjltAsunto.setNumAnioExpediente(demandaRequestDto.getCardDemanda().getAnioExpediente());
			mjltAsunto.setCveUsuarioAlta(demandaRequestDto.getCveUsuario());
//			mjltAsunto.setIndReponeProcedimiento(demandaRequestDto.getCardDemanda().get); TODO: Validar si se persiste el ind_procede_incopetencia
			
			//Actor Principal
			MjltAsuntoActor mjltAsuntoActor = new MjltAsuntoActor();
			mjltAsuntoActor.setCveAsunto(mjltAsunto);
			mjltAsuntoActor.setCveUsuarioAlta(demandaRequestDto.getCveUsuario());
			mjltAsuntoActor.setRefNombre(demandaRequestDto.getCardActorPrincipal().getNombre());
			mjltAsuntoActor.setRefPaterno(demandaRequestDto.getCardActorPrincipal().getApMaterno());
			mjltAsuntoActor.setRefMaterno(demandaRequestDto.getCardActorPrincipal().getApMaterno());
			mjltAsuntoActor.setRefMatricula(demandaRequestDto.getCardActorPrincipal().getMatricula());
			mjltAsuntoActor.setRefNss(demandaRequestDto.getCardActorPrincipal().getAfiliacion());
			mjltAsuntoActor.setRefCurp(demandaRequestDto.getCardActorPrincipal().getCurp());
			mjltAsuntoActor.setRefRfc(demandaRequestDto.getCardActorPrincipal().getRfc());
			
			SsccSexo ssccSexo =  new SsccSexo();
			ssccSexo.setId(null);
			mjltAsuntoActor.setCveSexo(ssccSexo);
			
			mjltAsuntoActor.getCanSalarioBase();
			
			SsccUmf ssccUmf = new SsccUmf();
			ssccUmf.setId(null);
			mjltAsuntoActor.setCveUmf(ssccUmf);
			
			//Conflicto Individual de Seguridad Social
			mjltAsunto.setRefCissUltimoPatron(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getUltimmoPatron());
//			mjltAsunto.setRefCissUltimoPatron(null); TODO:falta estado
//			mjltAsunto.setRefCissUltimoPatron(null);TODO:falta alcaldia Municipio
			mjltAsunto.setRefCissDirCalle(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getCalle());
//			mjltAsunto.setRefCissDirCalle(null);TODO:colonia
			mjltAsunto.setRefCissDirNumExt(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getNumExterior());
			mjltAsunto.setRefCissDirNumInt(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getNumInterior());
			
			SsccColoniaCp ssccColoniaCp = new SsccColoniaCp();
			ssccColoniaCp.setRefCp(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getCodigoPostal());
			mjltAsunto.setRefCissDirCp(ssccColoniaCp);
			mjltAsunto.setFecCissNacimiento(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getFechaNacimiento());
//			mjltAsunto.setCveCissDocumentoPrueba(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getDocumentoAdjunto()); preguntar por la entidad de documento
			mjltAsunto.setIndCissPericialMedica(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getPericialMedica());
			//TODO://FINADO
			
			
			//TODO://ACCIONES RECLAMADAS
			
			//Datos del juicio
			mjltAsunto.setFecPresentacion(demandaRequestDto.getCardDatosJuicio().getFechaPresentacion());
			mjltAsunto.setFecNotificacion(demandaRequestDto.getCardDatosJuicio().getFechaNotificacion());
			mjltAsunto.setRefCodemandado(demandaRequestDto.getCardDatosJuicio().getCodemandado());
			
			SsccTrascendencia ssccTrascendencia = new SsccTrascendencia();
			ssccTrascendencia.setId(demandaRequestDto.getCardDatosJuicio().getTipoTrascendencia());
			mjltAsunto.setCveTrascendencia(ssccTrascendencia);
			mjltAsunto.setStpAudienciaInicial(demandaRequestDto.getCardDatosJuicio().getFechaAudienciaInicial());
			
			//Abogado Responsable
			SsccUsuario ssccUsuario = new  SsccUsuario();
			ssccUsuario.setId(demandaRequestDto.getCardAbogadoResponsable().getAbogado());
			mjltAsunto.setCveUsuarioAbogadoResponsable(ssccUsuario);
			mjltAsunto.setFecAsignacion(demandaRequestDto.getCardAbogadoResponsable().getFechaAsignacion());
			


			MjltAsuntoActor dbo = Try.of(() -> ObjectMapperUtils.map(demandaRequestDto, MjltAsuntoActor.class)).map(mjltAsuntoActorRepository::save).onFailure(exc -> log.error("Cannot insert or update record", exc)).get();
			
			log.info("NOTA REPOSITORY DEMANDA " + demandaRequestDto.getCardDemanda());
			actorPrincipalService.save(demandaRequestDto.getCardActorPrincipal());
			
			conflictoIndividualSeguridadSocialService.save(demandaRequestDto.getCardConflictoIndividualSeguridadSocial());
			
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
