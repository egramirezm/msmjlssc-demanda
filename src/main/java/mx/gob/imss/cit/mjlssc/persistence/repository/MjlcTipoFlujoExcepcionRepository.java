package mx.gob.imss.cit.mjlssc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.gob.imss.cit.mjlssc.persistence.entity.MjlcTipoFlujoExcepcion;

@Repository
public interface MjlcTipoFlujoExcepcionRepository extends JpaRepository<MjlcTipoFlujoExcepcion, Integer> {
	
}