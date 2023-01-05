package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoDto;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccDelegacion;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidaDemandaResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128052803305186026L;
	
    private String mensaje;
	private  MjltAsuntoDto demanda;
	
}