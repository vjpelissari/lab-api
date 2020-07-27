package br.com.jantorno.labapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jantorno.labapi.domain.Exame;
import br.com.jantorno.labapi.domain.Status;
import br.com.jantorno.labapi.repository.ExameRepository;
import br.com.jantorno.labapi.services.exeptions.ExameNaoEncontradoException;
import br.com.jantorno.labapi.services.exeptions.NomeExameExistenteException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;
	
		public List<Exame> listar() {
		return exameRepository.findAll();
	}
	
	public Exame buscar(Long id) {
		Exame exame = this.exameRepository.findById(id).orElse(null);
		
		if(exame == null) {
			throw new ExameNaoEncontradoException("O exame não foi encontrado.");
		}
		return exame;
	}
	
	public Exame salvar(Exame exame) {
		
		Exame exame_pesquisado = exameRepository.findByNome(exame.getNome());
		
		if (exame_pesquisado != null) {
			throw new NomeExameExistenteException("O nome do exame já encontra-se cadastrado.");
		}
	
		exame.setId(null);
		return exameRepository.save(exame);
	}
	
	public void deletar(Long id) {
		try {
			//exameRepository.deleteById(id);
			exameRepository.setStatusExame(Status.INATIVO, id);
		} catch (EmptyResultDataAccessException e) {
			throw new ExameNaoEncontradoException("O exame não foi encontrado.");
		}
	}
	
	public void atualizar(Exame exame) {
        this.verificarExistencia(exame);
    	this.validarNomeUpdate(exame);
    	
		exameRepository.save(exame);
	}
	
	private void verificarExistencia(Exame exame) {
		buscar(exame.getId());
	}
	
	private void validarNomeUpdate(Exame exame) {
        
		Exame examePesquisa = exameRepository.findByNome(exame.getNome());

		if ((examePesquisa != null) && (examePesquisa.getId() != exame.getId())) {
			throw new NomeExameExistenteException("O nome do exame já encontra-se cadastrado.");
		}
	}	
}