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
import net.ufjnet.joppool.models.Empresa;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true,  callSuper = false)
@JsonPropertyOrder({"codigo_empresa","nome_empresa","nome_empresa","cnpj_empresa","email_empresa","telefone_empresa","endereco_empresa","cidade_empresa","estado_empresa","areaAtuacao_empresa"})
public class EmpresaDTO extends RepresentationModel<EmpresaDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_empresa")
	private Integer idEmpresa;
	
	@JsonProperty("nome_empresa")
	private String nome;
	
	@JsonProperty("cnpj_empresa")
	private String cnpj;
	
	@JsonProperty("email_empresa")
	private String email;

	@JsonProperty("telefone_empresa")
	private String telefone;

	@JsonProperty("endereco_empresa")
	private String endereco;

	@JsonProperty("cidade_empresa")
	private String cidade;

	@JsonProperty("estado_empresa")
	private String estado;

	@JsonProperty("areaAtuacao_empresa")
	private String areaAtuacao;

	public EmpresaDTO(Empresa obj) {
		this.idEmpresa = obj.getIdEmpresa();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.areaAtuacao = obj.getAreaAtuacao();
	}
	
	
	
}
