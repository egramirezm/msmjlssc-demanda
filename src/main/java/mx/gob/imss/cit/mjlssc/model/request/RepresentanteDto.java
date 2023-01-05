package mx.gob.imss.cit.mjlssc.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gob.imss.cit.mjlssc.model.entity.SsccEstadoDto;
import mx.gob.imss.cit.mjlssc.model.entity.SsccMunicipioAlcaldiaDto;
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
	private Integer nombreId;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String correoElectronico;
	private String telefono;
	private String despacho;
	private SsccEstadoDto estado;
	private SsccMunicipioAlcaldiaDto alcaldiaMunicipio;
	private String calle;
	private Integer colonia;
	private String numExterior;
	private String numInterior;
	private String codigoPostal;
	

}