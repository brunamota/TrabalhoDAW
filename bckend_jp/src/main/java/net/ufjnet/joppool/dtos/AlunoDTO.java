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
	@JsonProperty("nome_aluno")
	private String nome;
	@JsonProperty("cpf_aluno")
	private String cpf;
	@JsonProperty("email_aluno")
	private String email;
	@JsonProperty("nascimento_aluno")
	private String dataNascimento;
	@JsonProperty("telefone_aluno")
	private String telefone;
	@JsonProperty("endereco_aluno")
	private String endereco;
	@JsonProperty("cidade_aluno")
	private String cidade;
	@JsonProperty("estado_aluno")
	private String estado;
	@JsonProperty("instituicao_aluno")
	private String instituicao;
	@JsonProperty("curso_aluno")
	private String curso;
	@JsonProperty("matricula_aluno")
	private String matricula; 
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
