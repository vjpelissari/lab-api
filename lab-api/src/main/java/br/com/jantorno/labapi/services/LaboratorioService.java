package br.com.jantorno.labapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jantorno.labapi.domain.Laboratorio;
import br.com.jantorno.labapi.domain.Status;
import br.com.jantorno.labapi.repository.LaboratorioRepository;
import br.com.jantorno.labapi.services.exeptions.LaboratorioNaoEncontradoException;
import br.com.jantorno.labapi.services.exeptions.NomeLaboratorioExistenteException;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public List<Laboratorio> listar() {
		return laboratorioRepository.findAll();
	}
	
	public Laboratorio buscar(Long id) {
		Laboratorio laboratorio = this.laboratorioRepository.findById(id).orElse(null);
		
		if(laboratorio == null) {
			throw new LaboratorioNaoEncontradoException("O laboratorio não foi encontrado.");
		}
		return laboratorio;
	}
	
	public Laboratorio salvar(Laboratorio laboratorio) {
		
		Laboratorio laboratorio_pesquisado = laboratorioRepository.findByNome(laboratorio.getNome());
		
		if (laboratorio_pesquisado != null) {
			throw new NomeLaboratorioExistenteException("O nome do laboratorio já encontra-se cadastrado.");
		}
	
		laboratorio.setId(null);
		return laboratorioRepository.save(laboratorio);
	}
	
	public void deletar(Long id) {
		try {
			//laboratorioRepository.deleteById(id);
			laboratorioRepository.setStatusLaboratorio(Status.INATIVO, id);
		} catch (EmptyResultDataAccessException e) {
			throw new LaboratorioNaoEncontradoException("O laboratorio não foi encontrado.");
		}
	}
	
	public void atualizar(Laboratorio laboratorio) {
        this.verificarExistencia(laboratorio);
    	this.validarNomeUpdate(laboratorio);

    	// TODO: Incluir exames existentes
    	
		laboratorioRepository.save(laboratorio);
	}
	
	private void verificarExistencia(Laboratorio laboratorio) {
		buscar(laboratorio.getId());
	}
	
	private void validarNomeUpdate(Laboratorio laboratorio) {
        
		Laboratorio laboratorioPesquisa = laboratorioRepository.findByNome(laboratorio.getNome());

		if ((laboratorioPesquisa != null) && (laboratorioPesquisa.getId() != laboratorio.getId())) {
			throw new NomeLaboratorioExistenteException("O nome do laboratorio já encontra-se cadastrado.");
		}
	}

	public List<Laboratorio> buscarlaboratoriosPorNomeExame(String nome) {
		System.out.println("Services: " + nome);
		return laboratorioRepository.getLaboratoriosNomeExame(nome);
	}
}