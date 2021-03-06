package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ufjnet.joppool.models.Habilidade;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true,  callSuper = false)
@JsonPropertyOrder({"codigo_habilidade","conhecimentos_habilidade"})
public class HabilidadeDTO extends RepresentationModel<HabilidadeDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidade;
	
	@Size(max = 255)
	@NotBlank
	@Column(name = "conhecimentos_habilidade", nullable = false)
	@JsonProperty("conhecimentos_vaga")
	private String conhecimentos;

	//@ConvertGroup(from=Default.class, to = ValidationGroups.AlunoId.class)
	//@NotNull
	//@Valid
	//private AlunoDTO aluno;

	public HabilidadeDTO(Habilidade obj) {
		this.idHabilidade = obj.getIdHabilidade();
		this.conhecimentos = obj.getConhecimentos();
		
		//aluno = new AlunoDTO(obj.getAluno());
	}
}
