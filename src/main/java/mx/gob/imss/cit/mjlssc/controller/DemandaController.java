/**
 * 
 */
package mx.gob.imss.cit.mjlssc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.gob.imss.cit.mjlssc.model.entity.MjltAsuntoDto;
import mx.gob.imss.cit.mjlssc.model.entity.ResponseDataDTO;
import mx.gob.imss.cit.mjlssc.model.request.DemandaRegisRequestDto;
import mx.gob.imss.cit.mjlssc.model.request.ValidaDemandaResponseDto;
import mx.gob.imss.cit.mjlssc.service.DemandaService;
import mx.gob.imss.cit.mjlssc.utils.Constantes;

/***
 * 
 * @author
 *
 */
@Log4j2
@RestController
@RequestMapping("/demanda")
public class DemandaController {

	@Autowired
	private DemandaService demandaService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody DemandaRegisRequestDto requestDto) {
		log.info("--->> Save registro de la demanda: " + requestDto);
		return demandaService.save(requestDto);
	}
//	
//	@GetMapping("/get")
//	public ResponseEntity<ResponseDataDTO<List<MjltAsuntoDto>>> validaDemanda(@RequestParam Integer numExpediente, @RequestParam Integer anioExpediente) {
//		log.info("--->> validaDemanda::numExpediente:{} | anioExpediente:{}", numExpediente, anioExpediente);
//		try {
//			List<MjltAsuntoDto> resultList = demandaService.getDemanda(numExpediente, anioExpediente);
//			if(!resultList.isEmpty()) {
//				ResponseDataDTO<List<MjltAsuntoDto>> response = new ResponseDataDTO<>(Constantes.STATUS_200, Constantes.OK, resultList);
//				return new ResponseEntity<>(response, HttpStatus.OK);
//			}else {
//				ResponseDataDTO<List<MjltAsuntoDto>> response = new ResponseDataDTO<>(Constantes.STATUS_204, Constantes.NO_CONTENT, resultList);
//				return new ResponseEntity<>(response, HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			ResponseDataDTO<List<MjltAsuntoDto>> response = new ResponseDataDTO<>(Constantes.STATUS_500, Constantes.INTERNAL_SERVER_ERROR.concat(e.toString()), null);
//			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDataDTO<ValidaDemandaResponseDto>> validaDemanda(@RequestParam Integer numExpediente, @RequestParam Integer anioExpediente,@RequestParam Integer cveJunta, @RequestParam Boolean indProcedIncomp) {
		log.info("--->> validaDemanda::numExpediente:{} | anioExpediente:{}", numExpediente, anioExpediente);
		try {
			ValidaDemandaResponseDto response = demandaService.validaDemanda(
					numExpediente, anioExpediente,cveJunta,indProcedIncomp);
			
			ResponseDataDTO<ValidaDemandaResponseDto> responseData = new ResponseDataDTO<>(Constantes.STATUS_200, Constantes.OK, response);
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		
		} catch (Exception e) {
			ResponseDataDTO<ValidaDemandaResponseDto> response = new ResponseDataDTO<>(Constantes.STATUS_500, Constantes.INTERNAL_SERVER_ERROR.concat(e.toString()), null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
