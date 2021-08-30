package net.ufjnet.joppool.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "Vagas")
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_vaga")
	private Integer idVaga;
	
	@Column(name = "nome_vaga", nullable = false)
	private String nome;

	@Column(name = "quantidade_vaga", nullable = false)
	private String quantidade;

	@Column(name = "porcetagem_vaga", nullable = false)
	private int porcentagem;

	@Column(name = "remuneracao_vaga", nullable = false)
	private String remuneracao;

	@Column(name = "atividades_vaga", nullable = false)
	private String atividades;

	@Column(name = "horasSemanais_vaga", nullable = false)
	private String horasSemanais;

	@Column(name = "periodoDia_vaga", nullable = false)
	private String periodoDia;
	
	@ManyToOne()
	private Empresa empresa;
	
	//pensar se a empresa pode ter um campo para colocar uma descrição
	
}
