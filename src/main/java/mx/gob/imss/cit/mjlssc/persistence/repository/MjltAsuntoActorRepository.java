package mx.gob.imss.cit.mjlssc.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsuntoActor;

@Repository
public interface MjltAsuntoActorRepository extends JpaRepository<MjltAsuntoActor, Integer> {

	@Query(value="Select ac FROM MjltAsuntoActor ac " 
			+ "JOIN  ac.cveAsunto  asu " 
			+ "JOIN asu.cveTipoAsuntoEtapaConfig cfg " 
			+ "WHERE  asu.fecBaja IS NULL "
			+ "AND (ac.refNombre IS NULL OR ac.refNombre LIKE CONCAT(?1, '%')) "
			+ "AND (asu.numExpediente IS NULL OR asu.numExpediente LIKE CONCAT(?2, '%')) "
			+ "AND (asu.numAnioExpediente IS NULL OR asu.numAnioExpediente LIKE CONCAT(?3, '%')) "
			+ "AND (cfg.id IS NULL OR cfg.id LIKE CONCAT(?4, '%')) ",
			countQuery = "Select count (ac.id) FROM MjltAsuntoActor ac " 
					+ "JOIN  ac.cveAsunto  asu " 
					+ "JOIN  asu.cveTipoAsuntoEtapaConfig cfg " 
					+ "WHERE  asu.fecBaja IS NULL "
					+ "AND (ac.refNombre IS NULL OR ac.refNombre LIKE CONCAT(?1, '%')) "
					+ "AND (asu.numExpediente IS NULL OR asu.numExpediente LIKE CONCAT(?2, '%')) "
					+ "AND (asu.numAnioExpediente IS NULL OR asu.numAnioExpediente LIKE CONCAT(?3, '%')) "
					+ "AND (cfg.id IS NULL OR cfg.id LIKE CONCAT(?4, '%')) "
			)
	Page<MjltAsuntoActor> findAsuntoActorHome(String nombre, Integer folio, Integer numAnioExpediente,Integer cveEdoProcesal,Pageable pageable);

}