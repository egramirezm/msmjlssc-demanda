package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccDelegacion;

/**
 * A DTO for the {@link SsccDelegacion} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosJuicioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128052803305186026L;
	private String codemandado;
	private Date fechaPresentacion;
	private Date fechaNotificacion;
	private Date fechaAudienciaInicial;
	private Integer tipoTrascendencia;
	private String hora;

}