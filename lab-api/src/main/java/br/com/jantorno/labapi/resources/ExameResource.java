package br.com.jantorno.labapi.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jantorno.labapi.domain.Exame;
import br.com.jantorno.labapi.services.ExameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/exames")
@Api(value = "API Rest Exame")
@CrossOrigin(origins="*")
public class ExameResource {

	@Autowired
	private ExameService exameServices;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna a lista de todos os exames ativos cadastrados.")
	public ResponseEntity<List<Exame>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(exameServices.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna a busca de um exame.")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Exame exame = exameServices.buscar(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(exame);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Salva um exame.")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Exame exame) {
		exame = exameServices.salvar(exame);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(exame.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Remove logicamente um exame.")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		exameServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Remove um exame.")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		exameServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	*/
		
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value="Atualiza um exame.")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody Exame exame, 
			@PathVariable("id") Long id) {
		exame.setId(id);
		exameServices.atualizar(exame);
		return ResponseEntity.noContent().build();
	}	
}