/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoActorDto;
import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsuntoActor;
import mx.gob.imss.cit.mjlssc.persistence.repository.MjltAsuntoActorRepository;
import mx.gob.imss.cit.mjlssc.service.HomeService;
import mx.gob.imss.cit.mjlssc.utils.ObjectMapperUtils;

/**
 * @author
 *
 */
@Log4j2
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private MjltAsuntoActorRepository mjltAsuntoActorRepository;

	@Override
	public Object getHomeJuicioLaboral(String nombre, Integer folio, Integer anio, Integer cveEdoProcesal,Pageable pageable) {
		log.info("Inicio home juicoLaboral");
		Page<MjltAsuntoActor> actores = null;
		List<MjltAsuntoActorDto> actoresDto = new ArrayList<>();
		try {
			actores = mjltAsuntoActorRepository.findAsuntoActorHome(nombre, folio, anio, cveEdoProcesal, pageable);
			actoresDto = ObjectMapperUtils.mapAll(actores.getContent(), MjltAsuntoActorDto.class);
		} catch (Exception e) {
			log.error("error getHomeJuicioLaboral", e);
		}
		return new PageImpl<>(actoresDto, pageable, actores.getTotalElements());
	}

}
