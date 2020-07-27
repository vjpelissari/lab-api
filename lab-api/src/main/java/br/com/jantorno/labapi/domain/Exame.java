package br.com.jantorno.labapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@NamedQuery(name = "Exame.findAll", query="select l from Exame l where l.status = 1 order by l.nome")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Size (max = 100, message = "O nome do exame não pode ter mais que 100 caracteres.") 
	@NotNull (message = "Nome do exame não pode ser nulo.")
	@NotEmpty (message = "Nome do exame não pode ser vazio.")
	@NotBlank (message = "Nome do exame não pode estar em branco.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Enumerated(EnumType.ORDINAL)
	private TipoExame tipoExame;

	@JsonInclude(Include.NON_NULL)
	@Enumerated(EnumType.ORDINAL)
	private Status status = Status.ATIVO;
	
	@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable (
			uniqueConstraints = @UniqueConstraint(columnNames = {"id_laboratorio", "id_exame"}),
			name = "LabsExames",
			joinColumns = @JoinColumn(name="id_exame"),
			inverseJoinColumns = @JoinColumn(name="id_laboratorio")
	)
	@JsonIgnore
	private List<Laboratorio> laboratorios;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
}