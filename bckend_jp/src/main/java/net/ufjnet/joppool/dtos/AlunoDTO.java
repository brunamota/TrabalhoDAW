package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
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
import net.ufjnet.joppool.models.Aluno;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_aluno","nome_aluno", "cpf_aluno","email_aluno", "nascimento_aluno", "telefone_aluno", "endereco_aluno","cidade_aluno","estado_aluno", "instituicao_aluno", "curso_aluno", "matricula_aluno", "periodo_aluno"})
public class AlunoDTO extends RepresentationModel<AlunoDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_aluno")
	private Integer idAluno;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("nome_aluno")
	private String nome;
	
	@Size(max=14)//000.000.000-00
	@NotBlank
	@JsonProperty("cpf_aluno")
	private String cpf;
	
	@Email
	@NotBlank
	@JsonProperty("email_aluno")
	private String email;
	
	
	@Size(max=10)// 00/00/0000
	@NotBlank
	@JsonProperty("nascimento_aluno")
	private String dataNascimento;
	
	@Size(max=14)//(00)00000-0000
	@NotBlank
	@JsonProperty("telefone_aluno")
	private String telefone;
	
	@Size(max=255)
	@NotBlank
	@JsonProperty("endereco_aluno")
	private String endereco;
	
	@Size(max=30)
	@NotBlank
	@JsonProperty("cidade_aluno")
	private String cidade;
	
	@Size(max=2)//sigla
	@NotBlank
	@JsonProperty("estado_aluno")
	private String estado;
	
	@Size(max=60)
	@NotBlank
	@JsonProperty("instituicao_aluno")
	private String instituicao;
	
	@Size(max=40)
	@NotBlank
	@JsonProperty("curso_aluno")
	private String curso;
	
	@Size(max=9)//000000000
	@NotBlank
	@JsonProperty("matricula_aluno")
	private String matricula; 
	
	@Size(max=15)
	@NotBlank
	@JsonProperty("periodo_aluno")
	private String periodo;

	public AlunoDTO(Aluno obj) {
		this.idAluno = obj.getIdAluno();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.dataNascimento =  obj.getDataNascimento();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.instituicao = obj.getInstituicao();
		this.curso = obj.getCurso();
		this.matricula = obj.getMatricula();
		this.periodo = obj.getPeriodo();
	}
		
}
