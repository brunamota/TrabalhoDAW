package net.ufjnet.joppool.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Alunos")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;


	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_aluno")
	private Integer idAluno;
	
	@Column(name = "nome_aluno", nullable = false)
	private String nome;

	@Column(name = "cpf_aluno", nullable = false)
	private String cpf;

	@Column(name = "email_aluno", nullable = false)
	private String email;

	@Column(name = "nascimento_aluno", nullable = false)
	private String dataNascimento;

	@Column(name = "telefone_aluno", nullable = false)
	private String telefone;

	@Column(name = "endereco_aluno", nullable = false)
	private String endereco;

	@Column(name = "cidade_aluno", nullable = false)
	private String cidade;

	@Column(name = "estado_aluno", nullable = false)
	private String estado;

	@Column(name = "instituicao_aluno", nullable = false)
	private String instituicao;

	@Column(name = "curso_aluno", nullable = false)
	private String curso;

	@Column(name = "matricula_aluno", nullable = false)
	private String matricula;

	@Column(name = "periodo_aluno", nullable = false)
	private String periodo;
	
	@OneToMany(mappedBy = "aluno")
	private List<Habilidade>habilidades = new ArrayList<>();

	public Aluno(Integer idAluno, String nome, String cpf, String email, String dataNascimento, String telefone,
			String endereco, String cidade, String estado, String instituicao, String curso, String matricula,
			String periodo)
	{
		this.idAluno = idAluno;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.instituicao = instituicao;
		this.curso = curso;
		this.matricula = matricula;
		this.periodo = periodo;
	}
}
