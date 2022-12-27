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
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccClaseActorAccionReclam;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccColoniaCp;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccDelegacion;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccSexo;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccTipoAsunto;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccTipoAsuntoEtapaConfig;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccTrascendencia;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccUmf;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccUsuario;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsctRepresentante;
import mx.gob.imss.cit.mjlssc.persistence.repository.MjltAsuntoActorRepository;
import mx.gob.imss.cit.mjlssc.persistence.repository.MjltAsuntoRepository;
import mx.gob.imss.cit.mjlssc.service.DemandaService;
import mx.gob.imss.cit.mjlssc.utils.ObjectMapperUtils;

/**
 * @author
 *
 */
@Log4j2
@Service
public class DemandaImpl implements DemandaService {

	@Autowired
	private MjltAsuntoActorRepository mjltAsuntoActorRepository;
	
	@Autowired
	private MjltAsuntoRepository mjltAsuntoRepository;
	

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
		MjltAsunto mjltAsunto = new MjltAsunto();
		try {
			
			//Generales
			SsccDelegacion ssccDelegacion = new SsccDelegacion();
			ssccDelegacion.setId(demandaRequestDto.getCveDelegacion());
			mjltAsunto.setCveDelegacion(ssccDelegacion);
			
			SsccTipoAsunto ssccTipoAsunto = new SsccTipoAsunto();
			ssccTipoAsunto.setId(demandaRequestDto.getCveTipoAsunto());
			mjltAsunto.setCveTipoAsunto(ssccTipoAsunto);
			
			mjltAsunto.setCveUsuarioAlta(String.valueOf(demandaRequestDto.getCveUsuario()));
			
			SsccTipoAsuntoEtapaConfig ssccTipoAsuntoEtapaConfig = new SsccTipoAsuntoEtapaConfig();
			ssccTipoAsuntoEtapaConfig.setId(demandaRequestDto.getCveTipoAsuntoEtapaConfig());
			mjltAsunto.setCveTipoAsuntoEtapaConfig(ssccTipoAsuntoEtapaConfig);
			
			//Demanda
			SsccCentroConciliacion ssccCentroConciliacion = new SsccCentroConciliacion();			
			ssccCentroConciliacion.setId(demandaRequestDto.getCardDemanda().getJuntaId());
			mjltAsunto.setCveJuntaConciliacion(ssccCentroConciliacion);
			mjltAsunto.setNumExpediente(demandaRequestDto.getCardDemanda().getNumeroExpediente());
			mjltAsunto.setNumAnioExpediente(demandaRequestDto.getCardDemanda().getAnioExpediente());
			mjltAsunto.setCveJuntaConcDemandaRelac(ssccCentroConciliacion);//TODO:Revisar si es el dato correcto el que se envia aqui
			mjltAsunto.setNumAnioExpDemandaRelac(demandaRequestDto.getCardDemanda().getAnioExpedienteRelac());
			mjltAsunto.setNumExpDemandaRelac(demandaRequestDto.getCardDemanda().getNumeroExpedienteRelac());
			mjltAsunto.setIndReponeProcedimiento(demandaRequestDto.getCardDemanda().getIndReponeProcedimiento());
			mjltAsunto.setIndProcedeIncompetencia(demandaRequestDto.getCardDemanda().getIndProcedeIncompetencia());
			
			
			//Conflicto Individual de Seguridad Social
			mjltAsunto.setRefCissUltimoPatron(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getUltimoPatron());
			
//			SsccEstado ssccEstado = new SsccEstado();
//			ssccEstado.setId(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getEstado());
//			
//			SsccMunicipioAlcaldia ssccMunicipioAlcaldia = new SsccMunicipioAlcaldia();
//			ssccMunicipioAlcaldia.setCveEstado(ssccEstado);
//			
			SsccColoniaCp ssccColoniaCp = new SsccColoniaCp();
			ssccColoniaCp.setId(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getColonia());
			
			mjltAsunto.setRefCissDirCp(ssccColoniaCp);
			mjltAsunto.setRefCissDirCalle(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getCalle());
			mjltAsunto.setRefCissDirNumExt(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getNumExterior());
			mjltAsunto.setRefCissDirNumInt(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getNumInterior());
			
			mjltAsunto.setFecCissNacimiento(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getFechaNacimiento());
//			mjltAsunto.setCveCissDocumentoPrueba(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getDocumentoAdjunto()); preguntar por la entidad de documento
			mjltAsunto.setIndCissPericialMedica(demandaRequestDto.getCardConflictoIndividualSeguridadSocial().getPericialMedica());
			//TODO://FINADO
			
			
//			//Representante
			SsctRepresentante ssctRepresentante = new SsctRepresentante();
			ssctRepresentante.setId(demandaRequestDto.getCardRepresentante().get(0).getNombreId());
			
			
			//Acciones reclamadas
			SsccClaseActorAccionReclam ssccClaseActorAccionReclam = new SsccClaseActorAccionReclam();
			ssccClaseActorAccionReclam.setId(demandaRequestDto.getCardAccionesReclamadas().getAccionReclamado());
			
			//Datos del juicio
			mjltAsunto.setFecPresentacion(demandaRequestDto.getCardDatosJuicio().getFechaPresentacion());
			mjltAsunto.setFecNotificacion(demandaRequestDto.getCardDatosJuicio().getFechaNotificacion());
			mjltAsunto.setRefCodemandado(demandaRequestDto.getCardDatosJuicio().getCodemandado());
			
			SsccTrascendencia ssccTrascendencia = new SsccTrascendencia();
			ssccTrascendencia.setId(demandaRequestDto.getCardDatosJuicio().getTipoTrascendencia());
			mjltAsunto.setCveTrascendencia(ssccTrascendencia);
			mjltAsunto.setStpAudienciaInicial(demandaRequestDto.getCardDatosJuicio().getFechaAudienciaInicial());
			
			//Usuario
			SsccUsuario ssccUsuario = new  SsccUsuario();
			ssccUsuario.setId(demandaRequestDto.getCveUsuario());
			mjltAsunto.setCveUsuario(ssccUsuario);
			mjltAsunto.setFecAsignacion(demandaRequestDto.getCardAbogadoResponsable().getFechaAsignacion());
			
			MjltAsunto mjltAsuntoDBO = Try.of(() -> ObjectMapperUtils.map(mjltAsunto, MjltAsunto.class)).map(mjltAsuntoRepository::save).onFailure(exc -> log.error("Cannot insert or update record", exc)).get();
			
			//Actor Principal
			MjltAsuntoActor mjltAsuntoActor = new MjltAsuntoActor();
			mjltAsuntoActor.setCveAsunto(mjltAsuntoDBO);
			mjltAsuntoActor.setCveUsuarioAlta(String.valueOf(demandaRequestDto.getCveUsuario()));
			mjltAsuntoActor.setRefNombre(demandaRequestDto.getCardActorPrincipal().get(0).getNombre());
			mjltAsuntoActor.setRefPaterno(demandaRequestDto.getCardActorPrincipal().get(0).getApPaterno());
			mjltAsuntoActor.setRefMaterno(demandaRequestDto.getCardActorPrincipal().get(0).getApMaterno());
			mjltAsuntoActor.setRefMatricula(demandaRequestDto.getCardActorPrincipal().get(0).getMatricula());
			mjltAsuntoActor.setRefNss(demandaRequestDto.getCardActorPrincipal().get(0).getAfiliacion());
			mjltAsuntoActor.setRefCurp(demandaRequestDto.getCardActorPrincipal().get(0).getCurp());
			mjltAsuntoActor.setRefRfc(demandaRequestDto.getCardActorPrincipal().get(0).getRfc());
			mjltAsuntoActor.setIndActorPrincipal(demandaRequestDto.getCardActorPrincipal().get(0).getIndActorPrincipal());
			
			SsccSexo ssccSexo =  new SsccSexo();
			ssccSexo.setId(demandaRequestDto.getCardActorPrincipal().get(0).getGenero());
			mjltAsuntoActor.setCveSexo(ssccSexo);
			
			mjltAsuntoActor.getCanSalarioBase();
			
			SsccUmf ssccUmf = new SsccUmf();
			ssccUmf.setId(demandaRequestDto.getCardActorPrincipal().get(0).getUfm());
			mjltAsuntoActor.setCveUmf(ssccUmf);

			MjltAsuntoActor mjltAsuntoActorDBO = Try.of(() -> ObjectMapperUtils.map(mjltAsuntoActor, MjltAsuntoActor.class)).map(mjltAsuntoActorRepository::save).onFailure(exc -> log.error("Cannot insert or update record", exc)).get();
			log.info("RESPONSE:{}", mjltAsuntoActorDBO);
			
		} catch (Exception e) {
			log.error("Exception DatosJuicioImpl saveDatosJuicio", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(mjltAsunto, HttpStatus.OK);
	}

}
