package mx.gob.imss.cit.mjlssc.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsunto;

@Repository
public interface MjltAsuntoRepository extends JpaRepository<MjltAsunto, Integer> {

	List<MjltAsunto> findByNumExpedienteAndNumAnioExpediente(Integer numExpediente, Integer numAnioExpediente);

}