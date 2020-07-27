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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jantorno.labapi.domain.Laboratorio;
import br.com.jantorno.labapi.services.LaboratorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/laboratorios")
@Api(value = "API Rest Laboratorio")
@CrossOrigin(origins="*")
public class LaboratorioResource {

	@Autowired
	private LaboratorioService laboratorioServices;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna a lista de todos os laboratorios ativos cadastrados.")
	public ResponseEntity<List<Laboratorio>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(laboratorioServices.listar());
	}
	
	@RequestMapping(value = "/buscarlaboratorios", method=RequestMethod.GET)
	@ApiOperation(value="Retorna a lista de todos os laboratorios a partir do nome do exame")
	public ResponseEntity<List<Laboratorio>> buscarlaboratorios(@RequestParam("nome") String nome) {
		System.out.println("Nome do Exame: " + nome);
		List<Laboratorio> list = laboratorioServices.buscarlaboratoriosPorNomeExame(nome);
		System.out.println("Lista Retorno: " + list);
		return ResponseEntity.status(HttpStatus.OK).body(laboratorioServices.buscarlaboratoriosPorNomeExame(nome));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna a busca de um laboratorio.")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Laboratorio laboratorio = laboratorioServices.buscar(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(laboratorio);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Salva um laboratorio.")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Laboratorio laboratorio) {
		laboratorio = laboratorioServices.salvar(laboratorio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(laboratorio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Remove logicamente um laboratorio.")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		laboratorioServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Remove um laboratorio.")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		laboratorioServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	*/
		
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value="Atualiza um laboratorio.")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody Laboratorio laboratorio, 
			@PathVariable("id") Long id) {
		laboratorio.setId(id);
		laboratorioServices.atualizar(laboratorio);
		return ResponseEntity.noContent().build();
	}
}