package net.ufjnet.joppool.dtos;

import java.io.Serializable;

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
import net.ufjnet.joppool.models.Vaga;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true,  callSuper = false)
@JsonPropertyOrder({"codigo_vaga","nome_vaga","quantidade_vaga","porcentagem_vaga","remuneracao_vaga","atividades_vaga","horasSemanais_vaga", "periodo_vaga"})
public class VagaDTO extends RepresentationModel<VagaDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_vaga")
	private Integer idVaga;

	@Size(max = 60)
	@NotBlank
	@JsonProperty("nome_vaga")
	private String nome;
	
	@Size(max = 60)
	@NotBlank
	@JsonProperty("quantidade_vaga")
	private String quantidade;
	
	@Size(max = 3)//0% a 100%
	@NotBlank
	@JsonProperty("porcentagem_vaga")
	private int porcentagem;
	
	@Size(max = 12)
	@NotBlank
	@JsonProperty("remuneracao_vaga")
	private String remuneracao;
	
	@NotBlank
	@JsonProperty("atividades_vaga")
	private String atividades;
	
	@NotBlank
	@JsonProperty("horasSemanais_vaga")
	private String horasSemanais;
	
	@Size(max=2)//0 a 30
	@NotBlank
	@JsonProperty("periodo_vaga")
	private String periodoDia;
	
	@ConvertGroup(from = Default.class, to = ValidationGroups.EmpresaId.class)
	@NotNull
	@Valid
	private EmpresaDTO empresa;

	public VagaDTO(Vaga obj) {

		this.idVaga = obj.getIdVaga();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
		this.porcentagem = obj.getPorcentagem();
		this.remuneracao = obj.getRemuneracao();
		this.atividades = obj.getAtividades();
		this.horasSemanais = obj.getHorasSemanais();
		this.periodoDia = obj.getPeriodoDia();
		
		empresa = new EmpresaDTO(obj.getEmpresa());
	}
}
