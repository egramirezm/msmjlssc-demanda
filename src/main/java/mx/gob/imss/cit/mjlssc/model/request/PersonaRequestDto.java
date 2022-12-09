package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.nmlssc.support.model.IdentityBaseModel;

@Getter
@Setter
public class PersonaRequestDto extends IdentityBaseModel<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -854797975920272969L;

	private Integer claseActor;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String matricula;
	private String afiliacion;
	private String curp;
	private String rfc;
	private String genero;
	private String ufm;
	private Integer salarioBase;

}