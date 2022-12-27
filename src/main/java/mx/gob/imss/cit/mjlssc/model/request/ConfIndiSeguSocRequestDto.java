package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;
import java.util.Date;

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

	private String ultimoPatron;
	private Integer estado;
	private Integer alcaldiaMunicipio;
	private String calle;
	private Integer colonia;
	private String numExterior;
	private String numInterior;
	private String codigoPostal;
	private Date fechaNacimiento;
	private String documentoAdjunto;
	private Boolean pericialMedica;

}