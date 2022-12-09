package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.nmlssc.support.model.IdentityBaseModel;

@Getter
@Setter
public class ConfIndiSeguSocRequestDto extends IdentityBaseModel<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -854797975920272969L;

	private Integer ultimmoPatron;
	private String estado;
	private String alcaldiaMunicipio;
	private String calle;
	private String colonia;
	private String numExterior;
	private String numInterior;
	private String codigoPostal;
	private String fechaNacimiento;
	private String documentoAdjunto;
	private String pericialMedica;

}