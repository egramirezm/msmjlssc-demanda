package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.nmlssc.support.model.IdentityBaseModel;

@Getter
@Setter
public class DemandaRequestDto extends IdentityBaseModel<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -854797975920272969L;

	private Integer juntaId;
	private String numeroExpediente;
	private Integer anioExpediente;

}