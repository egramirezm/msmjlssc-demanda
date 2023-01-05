package mx.gob.imss.cit.mjlssc.persistence.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.response.HomeJuicioLaboralResponseDto;
import mx.gob.imss.cit.nmlssc.support.model.PageModel;

@Log4j2
@Repository
public class HomeJuicioLaboralRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * ver con felix filtro de nombre para actor secundario
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public PageModel<HomeJuicioLaboralResponseDto> getHomeJuicoLaboral(String nombre, Integer folio, Integer anio, Integer cveEdoProcesal,String shema,Pageable pageable){
		
	    int pageNumber =pageable.getPageNumber();
	    int pageSize = pageable.getPageSize();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT ").append(
				"CONCAT(LPAD(asu.NUM_EXPEDIENTE,4,'0'),'/',asu.NUM_ANIO_EXPEDIENTE,'/',LPAD(asu.CVE_JUNTA_CONCILIACION,4,'0')) AS 'numExpediente', ")
				.append("asu.CVE_ASUNTO as 'cveAsunto', ")
				.append("actor.CVE_ASUNTO_ACTOR as 'cveAsuntoActor', ")
				.append("asu.CVE_JUNTA_CONCILIACION as 'cveJunta', ")
				.append("scc.DES_CENTRO_CONCILIACION  as 'junta', ")
				.append("etapas.DES_TIPO_ASUNTO_ETAPA_CONFIG as 'siguienteActividad', ")
				.append("CONCAT_WS(' ',actor.REF_NOMBRE,actor.REF_PATERNO,actor.REF_MATERNO) AS 'actorPricipal',")
				.append("if(asu.FEC_MODIFICA is null,asu.FEC_ALTA,asu.FEC_MODIFICA) as 'actualizacion', ")
				.append("(SELECT COUNT(*)FROM MJLT_ASUNTO_ACTOR where CVE_ASUNTO = asu.CVE_ASUNTO) as 'actores' ")

				//from
				.append("FROM MJLT_ASUNTO asu ")
				.append("INNER JOIN ").append(shema)
				.append(".SSCC_TIPO_ASUNTO_ETAPA_CONFIG etapas on etapas.CVE_TIPO_ASUNTO_ETAPA_CONFIG = asu.CVE_TIPO_ASUNTO_ETAPA_CONFIG ")
				.append("INNER JOIN MJLT_ASUNTO_ACTOR actor on actor.CVE_ASUNTO = asu.CVE_ASUNTO and actor.IND_ACTOR_PRINCIPAL = 1 ")
				.append("INNER JOIN ").append(shema)
				.append(".SSCC_CENTRO_CONCILIACION scc on asu.CVE_JUNTA_CONCILIACION = scc.CVE_CENTRO_CONCILIACION ")

				//condiciones
				.append("WHERE asu.FEC_BAJA IS NULL ");

	    		//filtros
				sql.append("AND (:folio IS NULL OR asu.NUM_EXPEDIENTE LIKE CONCAT('%',:folio,'%')) ");
				sql.append("AND (:anio  IS NULL OR asu.NUM_ANIO_EXPEDIENTE LIKE CONCAT('%',:anio,'%')) ");
				sql.append("AND (:nombre IS NULL OR CONCAT_WS(' ',actor.REF_NOMBRE, actor.REF_PATERNO,actor.REF_MATERNO) LIKE CONCAT('%',:nombre,'%')) ");

				/*
			    if (!StringUtils.isEmpty(anio)) {
			    	sql.append("AND asu.NUM_ANIO_EXPEDIENTE = ").append(anio).append(" ");
			    }
			  
			    if (!StringUtils.isEmpty(nombre)) {
			    	sql.append("AND CONCAT_WS(' ',actor.REF_NOMBRE, actor.REF_PATERNO,actor.REF_MATERNO) LIKE CONCAT('%','").append(nombre).append("','%') ");
			    	//sql.append("AND ( CONCAT_WS(' ',actor.REF_NOMBRE, actor.REF_PATERNO,actor.REF_MATERNO) LIKE CONCAT('%',:nombre ,'%') or CONCAT_WS(' ',actor.REF_NOMBRE, actor.REF_PATERNO,actor.REF_MATERNO) is null) ");
			    }
				 **/
		log.error("consulta home juicio laboral:{}" + sql);
		List<HomeJuicioLaboralResponseDto> listReporteAsuntoDTO = entityManager.createNativeQuery(sql.toString())
				.setParameter("folio",folio)
				.setParameter("anio",anio)
				.setParameter("nombre",nombre)
				.setFirstResult((pageNumber) * pageSize).setMaxResults(pageSize).unwrap(org.hibernate.Query.class)
				.setResultTransformer(Transformers.aliasToBean(HomeJuicioLaboralResponseDto.class)).list();

		PageModel<HomeJuicioLaboralResponseDto> response = new PageModel<HomeJuicioLaboralResponseDto>();
		response.setContent(listReporteAsuntoDTO);
		long totalElements = entityManager.createNativeQuery(sql.toString())
				.setParameter("folio",folio)
				.setParameter("anio",anio) 
				.setParameter("nombre",nombre) 
				.getResultList().size();
		response.setTotalElements(totalElements);
		int incrementoPage = totalElements % pageSize == 0 ? 0 : 1;
		response.setTotalPages((int) totalElements / pageSize + incrementoPage);
		response.setSize(listReporteAsuntoDTO.size());
		response.setNumber(pageNumber + 1);
		response.setNumberOfElements((int) totalElements);
		return response;
	    
		}
	
}
