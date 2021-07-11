package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@JsonPropertyOrder({"codigo_vaga","nome_vaga","quantidade_vaga","porcentagem_vaga","remuneracao_vaga","requisitos_vaga","atividades_vaga","horasSemanais_vaga", "periodo_vaga"})
public class VagaDTO extends RepresentationModel<VagaDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_vaga")
	private Integer idVaga;

	@JsonProperty("nome_vaga")
	private String nome;
	
	@JsonProperty("quantidade_vaga")
	private String quantidade;
	
	@JsonProperty("porcentagem_vaga")
	private String porcentagem;
	
	@JsonProperty("remuneracao_vaga")
	private String remuneracao;
	
	@JsonProperty("requisitos_vaga")
	private String requisitos;
	
	@JsonProperty("atividades_vaga")
	private String atividades;
	
	@JsonProperty("horasSemanais_vaga")
	private String horasSemanais;
	
	@JsonProperty("periodo_vaga")
	private String periodoDia;

	public VagaDTO(Vaga obj) {

		this.idVaga = obj.getIdVaga();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
		this.porcentagem = obj.getPorcentagem();
		this.remuneracao = obj.getRemuneracao();
		this.requisitos = obj.getRequisitos();
		this.atividades = obj.getAtividades();
		this.horasSemanais = obj.getHorasSemanais();
		this.periodoDia = obj.getPeriodoDia();
	}
	
	
	

}
