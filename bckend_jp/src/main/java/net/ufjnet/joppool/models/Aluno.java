package net.ufjnet.joppool.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
