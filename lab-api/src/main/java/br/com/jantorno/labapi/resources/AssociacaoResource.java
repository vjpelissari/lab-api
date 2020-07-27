package br.com.jantorno.labapi.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jantorno.labapi.domain.Exame;
import br.com.jantorno.labapi.domain.Laboratorio;
import br.com.jantorno.labapi.domain.LabsExame;
import br.com.jantorno.labapi.domain.TipoAssociacao;
import br.com.jantorno.labapi.services.ExameService;
import br.com.jantorno.labapi.services.LaboratorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/associacao")
@Api(value = "API Rest Associar Exame ao Laboratorio")
@CrossOrigin(origins="*")
public class AssociacaoResource {
	
	@Autowired
	private ExameService exameServices;
	
	@Autowired
	private LaboratorioService laboratorioServices;
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Associa Exame ao Laboratorio.")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody LabsExame labsExame) {
	
		Laboratorio laboratorio = laboratorioServices.buscar(labsExame.getIdLaboratorio());
		Exame exame = exameServices.buscar(labsExame.getIdExame());

		if (labsExame.getTipo() == TipoAssociacao.ASSOCIAR) {
			laboratorio.getExames().add(exame);
		} 
		else if	(labsExame.getTipo() == TipoAssociacao.DESASSOCIAR) {
			laboratorio.getExames().remove(exame);
		}
		
		laboratorioServices.atualizar(laboratorio);
		
		return ResponseEntity.noContent().build();
	}
}