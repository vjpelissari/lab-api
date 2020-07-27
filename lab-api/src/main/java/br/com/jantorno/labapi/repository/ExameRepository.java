package br.com.jantorno.labapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.jantorno.labapi.domain.Exame;
import br.com.jantorno.labapi.domain.Status;

public interface ExameRepository extends JpaRepository<Exame, Long> {
	
	@Override
    @Query
    public List<Exame> findAll();
	
	public Exame findByNome(String nome);
	
	@Transactional
	@Modifying
	@Query("update Exame l set l.status = ?1 where l.id = ?2")
	public void setStatusExame (Status status, Long id);
}