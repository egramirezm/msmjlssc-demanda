package mx.gob.imss.cit.mjlssc.model.response;

import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.cit.nmlssc.support.model.BaseModel;

@Getter
@Setter
public class HomeJuicioLaboralResponseDto extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7636634098492637736L;

	private Integer cveAsunto;
	private Integer cveAsuntoActor;
	private String numExpediente;
	private Integer cveJunta;
	private String actorPricipal;
	private String siguienteActividad;
	private Date actualizacion;
	private BigInteger actores;

//	private Integer cveEstadoProcesal;
//	private String nomEstadoProcesal;
//	private Integer cveEstadoProcesalSiguiente;
//	private String nomEstadoProcesalSiguiente;
//	private Integer cveJuzgado;
//	private Integer numJuicioAmparo;
//	private Integer numAnio;
//	private Integer numFolio;

}