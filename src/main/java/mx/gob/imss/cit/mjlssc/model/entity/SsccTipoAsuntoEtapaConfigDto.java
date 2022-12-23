package mx.gob.imss.cit.mjlssc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gob.imss.cit.mjlssc.persistence.entity.SsccTipoAsuntoEtapaConfig;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link SsccTipoAsuntoEtapaConfig} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsccTipoAsuntoEtapaConfigDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6113714709782744767L;
	private Integer id;
    @NotNull
    private SsccTipoAsuntoDto cveTipoAsunto;
    @Size(max = 100)
    private String desTipoAsuntoEtapaConfig;
    private Integer numTareaOrigen;
    private Integer numTareaDestino;
    private Boolean indNotificacionActiva;
    private Boolean indNotificacionCordinador;
    private Boolean indNotificacionAbogado;
    private Boolean indNotificacionJefeDepto;
    private Boolean indNotificacionJefeServJur;
    private Boolean indNotificacionArea;
    private Boolean indNotificacionJefeDivision;
    private Integer numDiasVigencia;
    private Integer numDiasVigencia2;
    private Boolean indDigitalizacionObligatoria;
    @NotNull
    private Date fecAlta;
    private Date fecBaja;
    private Date fecModifica;
    @Size(max = 60)
    @NotNull
    private String cveUsuarioAlta;
    @Size(max = 60)
    private String cveUsuarioBaja;
    @Size(max = 60)
    private String cveUsuarioModifica;
}