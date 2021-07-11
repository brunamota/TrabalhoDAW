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
@Table(name = "Coordenadores")
public class Coordenador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_coordenador")
	private Integer idCoordenador;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "nome_coordenador", nullable = false)
	private String nome;
	
	@Size(max=14)
	@NotBlank
	@Column(name = "cpf_coordenador", nullable = false)
	private String cpf;
	
	@Email
	@NotBlank
	@Column(name = "email_coordenador", nullable = false)
	private String email;
	
	@Size(max=14)//(00)00000-0000
	@NotBlank
	@Column(name = "telefone_coordenador", nullable = false)
	private String telefone;
	
	@Size(max=30)
	@NotBlank
	@Column(name = "endereco_coordenador", nullable = false)
	private String endereco;
	
	@Size(max=30)
	@NotBlank
	@Column(name = "cidade_coordenador", nullable = false)
	private String cidade;
	
	@Size(max=2)//sigla
	@NotBlank
	@Column(name = "estado_coordenador", nullable = false)
	private String estado;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "instituicao_coordenador", nullable = false)
	private String instituicao;
	
	@Size(max=40)
	@NotBlank
	@Column(name = "curso_coordenador", nullable = false)
	private String curso;
	
	//vê como funciona os numeros das portarias
	@NotBlank
	@Column(name = "portaria_coordenador", nullable = false)
	private String portaria;
	
	//pensar em como adequar o numero de convenio ao coordenador e a empresa

}
