package br.com.jantorno.labapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jantorno.labapi.domain.Laboratorio;
import br.com.jantorno.labapi.domain.Status;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
	
	@Override
    @Query
    public List<Laboratorio> findAll();
	
	public Laboratorio findByNome(String nome);
	
	@Transactional
	@Modifying
	@Query("update Laboratorio l set l.status = ?1 where l.id = ?2")
	public void setStatusLaboratorio (Status status, Long id);
	
	@Query("select l from Laboratorio l join fetch l.exames e where e.nome = :name")
	public List<Laboratorio> getLaboratoriosNomeExame (@Param("name") String name);
	
	
	
	//public List<Laboratorio> getLaboratoriosNomeExame (String nome);
	
}