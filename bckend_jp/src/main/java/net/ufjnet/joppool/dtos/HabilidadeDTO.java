package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

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
@JsonPropertyOrder({"codigo_habilidade","cursosExtras_habilidade","conhecimentos_habilidade","experiencia_habilidade"})
public class HabilidadeDTO extends RepresentationModel<HabilidadeDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidade; //pensar se isso é realmente necessário para a
								  //relação e não apenas uma chave estrangeira
	@Size (max=255)
	@NotBlank
	@Column(name = "cursosExtras_habilidade", nullable = false)
	@JsonProperty("cursosExtras_vaga")
	private String cursosExtra;
	
	@Size(max = 60)
	@NotBlank
	@Column(name = "conhecimentos_habilidade", nullable = false)
	@JsonProperty("conhecimentos_vaga")
	private String conhecimentos;

	@Size(max = 60)
	@NotBlank
	@Column(name = "experiencia_habilidade", nullable = false)
	@JsonProperty("experiencia_vaga")
	private String experiencia;
	
	@ConvertGroup(from=Default.class, to = ValidationGroups.AlunoId.class)
	@NotNull
	@Valid
	private AlunoDTO aluno;

	public HabilidadeDTO(Habilidade obj) {
		this.idHabilidade = obj.getIdHabilidade();
		this.cursosExtra = obj.getCursosExtra();
		this.conhecimentos = obj.getConhecimentos();
		this.experiencia = obj.getExperiencia();
		
		aluno = new AlunoDTO(obj.getAluno());
	}
}
