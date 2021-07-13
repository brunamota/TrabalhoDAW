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
@Table(name = "Coordenadores")
public class Coordenador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_coordenador")
	private Integer idCoordenador;

	@Column(name = "nome_coordenador", nullable = false)
	private String nome;

	@Column(name = "cpf_coordenador", nullable = false)
	private String cpf;

	@Column(name = "email_coordenador", nullable = false)
	private String email;

	@Column(name = "telefone_coordenador", nullable = false)
	private String telefone;

	@Column(name = "endereco_coordenador", nullable = false)
	private String endereco;

	@Column(name = "cidade_coordenador", nullable = false)
	private String cidade;

	@Column(name = "estado_coordenador", nullable = false)
	private String estado;

	@Column(name = "instituicao_coordenador", nullable = false)
	private String instituicao;

	@Column(name = "curso_coordenador", nullable = false)
	private String curso;
	
	//vê como funciona os numeros das portarias
	@Column(name = "portaria_coordenador", nullable = false)
	private String portaria;
	
	//pensar em como adequar o numero de convenio ao coordenador e a empresa

}
