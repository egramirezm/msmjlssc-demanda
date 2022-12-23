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
public class RepresentanteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128052803305186026L;
	private Long nombreId;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String correoElectronico;
	private Integer telefono;
	private String despacho;
	//TODO: mapear el obejto de la entidad una vez que esten definidas
//	private EstadoDto estado;
//	private AlcaldiaMunicipioDto alcaldiaMunicipio;
	private String calle;
	private String colonia;
	private Integer numExterior;
	private Integer numInterior;
	private Integer codigoPostal;
	
	
	

}