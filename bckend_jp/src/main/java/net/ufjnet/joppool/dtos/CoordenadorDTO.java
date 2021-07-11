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
import net.ufjnet.joppool.models.Coordenador;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_coordenador","nome_coordenador", "cpf_coordenador", "email_coordenador", "telefone_coordenador", "endereco_coordenador","cidade_coordenador","estado_coordenador","instituicao_coordenador", "curso_coordenador", "portaria_coordenador"})
public class CoordenadorDTO extends RepresentationModel<CoordenadorDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_coordenador")
	private Integer idCoordenador;
	
	@JsonProperty("nome_coordenador")
	private String nome;
	
	@JsonProperty("cpf_coordenador")
	private String cpf;
	
	@JsonProperty("email_coordenador")
	private String email;
	
	@JsonProperty("telefone_coordenador")
	private String telefone;
	
	@JsonProperty("endereco_coordenador")
	private String endereco;

	@JsonProperty("cidade_coordenador")
	private String cidade;
	
	@JsonProperty("estado_coordenador")
	private String estado;

	@JsonProperty("instituicao_coordenador")
	private String instituicao;

	@JsonProperty("curso_coordenador")
	private String curso;

	@JsonProperty("portaria_coordenador")
	private String portaria;

	public CoordenadorDTO(Coordenador obj) {
		
		this.idCoordenador = obj.getIdCoordenador();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.instituicao = obj.getInstituicao();
		this.curso = obj.getCurso();
		this.portaria = obj.getPortaria();
	}

	
}
