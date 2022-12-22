/**
 * 
 */
package mx.gob.imss.cit.mjlssc.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoActorDto;
import mx.gob.imss.cit.mjlssc.persistence.entity.MjltAsuntoActor;
import mx.gob.imss.cit.mjlssc.persistence.repository.MjltAsuntoActorRepository;
import mx.gob.imss.cit.mjlssc.service.AntecedentesService;
import mx.gob.imss.cit.mjlssc.utils.ObjectMapperUtils;

/**
 * @author
 *
 */
@Log4j2
@Service
public class AntecedentesServiceImpl implements AntecedentesService {
	@Autowired
	private MjltAsuntoActorRepository mjltAsuntoActorRepository;

	@Override
	public List<MjltAsuntoActorDto> getDetalleActor() {
		log.info("Inicio getDetalleActor");

		try {
			List<MjltAsuntoActor> dboList = mjltAsuntoActorRepository.findAll();
			if (!dboList.isEmpty()) {
				return ObjectMapperUtils.mapAll(dboList, MjltAsuntoActorDto.class);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return  Collections.emptyList();
	}

	@Override
	public MjltAsuntoActorDto getDetalleActorByCveAsutoActor(Integer cveAsuntoActor) {
		log.info("Inicio getDetalleActorByCveAsutoActor");

		try {
			Optional<MjltAsuntoActor> dbo = mjltAsuntoActorRepository.findById(cveAsuntoActor);
			log.info(dbo.toString());
			if (dbo.isPresent()) {
				return ObjectMapperUtils.map(dbo.get(), MjltAsuntoActorDto.class);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return  null;
	}

}
