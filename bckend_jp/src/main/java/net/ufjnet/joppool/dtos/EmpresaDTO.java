package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotNull(groups = ValidationGroups.EmpresaId.class)
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_empresa")
	private Integer idEmpresa;
	
	@Size(max=60)
	@NotBlank
	@JsonProperty("nome_empresa")
	private String nome;
	
	@Size(max=18)//XX.XXX.XXX/0001-XX
	@NotBlank
	@JsonProperty("cnpj_empresa")
	private String cnpj;
	
	@Email
	@NotBlank
	@JsonProperty("email_empresa")
	private String email;

	@Size(max=14)//(00)00000-0000
	@NotBlank
	@JsonProperty("telefone_empresa")
	private String telefone;

	@Size(max=255)
	@NotBlank
	@JsonProperty("endereco_empresa")
	private String endereco;
	
	@Size(max=60)
	@NotBlank
	@JsonProperty("cidade_empresa")
	private String cidade;

	@Size(max=2)
	@NotBlank
	@JsonProperty("estado_empresa")
	private String estado;
	
	@Size(max=255)
	@NotBlank
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
