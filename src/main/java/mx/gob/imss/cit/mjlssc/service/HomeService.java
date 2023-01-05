package mx.gob.imss.cit.mjlssc.service;

import org.springframework.data.domain.Pageable;

public interface HomeService {

	Object getHomeJuicioLaboral(String nombre, Integer folio, Integer anio, Integer cveEdoProcesal,Pageable pageable);
}
