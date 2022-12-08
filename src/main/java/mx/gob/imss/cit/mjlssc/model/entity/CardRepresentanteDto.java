package mx.gob.imss.cit.mjlssc.model.entity;

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
public class CardRepresentanteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128052803305186026L;
	private Long nombreId;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String correoElectronico;
	private String telefono;
	private String despacho;
	//TODO: mapear el obejto de la entidad una vez que esten definidas
//	private EstadoDto estado;
//	private AlcaldiaMunicipioDto alcaldiaMunicipio;
	private String calle;
	private String colonia;
	private String numExterior;
	private String numInterior;
	private String codigoPostal;
	
	
	

}