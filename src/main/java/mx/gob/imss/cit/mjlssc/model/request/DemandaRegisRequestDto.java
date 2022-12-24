package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.nmlssc.support.model.IdentityBaseModel;
/**
 * Dto para el registor de una demanda.
 * 
 * @author lgarduno
 *
 */
@Getter
@Setter
public class DemandaRegisRequestDto extends IdentityBaseModel<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -854797975920272969L;

	
	private Integer cveAsunto;
	private String cveUsuario;
	private DemandaRequestDto cardDemanda;
	private PersonaRequestDto cardActorPrincipal;
	private ConfIndiSeguSocRequestDto cardConflictoIndividualSeguridadSocial;
	private ArrayList<PersonaRequestDto> cardFinado;
	private ArrayList<RepresentanteDto> cardRepresentante;
	private AccionesReclamadasDto cardAccionesReclamadas;
	private DatosJuicioDto cardDatosJuicio;
	private AbogadoResponsableDto cardAbogadoResponsable;

}