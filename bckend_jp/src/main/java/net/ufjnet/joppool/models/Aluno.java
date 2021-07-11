package net.ufjnet.joppool.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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
	
	@NotBlank
	@Size(max=60)
	@Column(name = "nome_aluno", nullable = false)
	private String nome;
	
	@Size(max=14)//000.000.000-00
	@NotBlank
	@Column(name = "cpf_aluno", nullable = false)
	private String cpf;
	
	@Email
	@NotBlank
	@Column(name = "email_aluno", nullable = false)
	private String email;
	
	@Size(max=10)// 00/00/0000
	@NotBlank
	@Column(name = "nascimento_aluno", nullable = false)
	private String dataNascimento;
	
	@Size(max=14)//(00)00000-0000
	@NotBlank
	@Column(name = "telefone_aluno", nullable = false)
	private String telefone;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "endereco_aluno", nullable = false)
	private String endereco;
	
	@Size(max=30)
	@NotBlank
	@Column(name = "cidade_aluno", nullable = false)
	private String cidade;
	
	@Size(max=2)//sigla
	@NotBlank
	@Column(name = "estado_aluno", nullable = false)
	private String estado;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "instituicao_aluno", nullable = false)
	private String instituicao;
	
	@Size(max=40)
	@NotBlank
	@Column(name = "curso_aluno", nullable = false)
	private String curso;
	
	@Size(max=9)//000000000
	@NotBlank
	@Column(name = "matricula_aluno", nullable = false)
	private String matricula;
	
	@Size(max=15)
	@NotBlank
	@Column(name = "periodo_aluno", nullable = false)
	private String periodo;
		
}
