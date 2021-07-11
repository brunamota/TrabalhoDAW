package net.ufjnet.joppool.models;

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
@Table(name = "Habilidades")
public class Habilidade {
	
	//criar relação entre vaga e aluno, talvez criar uma
	//tabela para os pré-requisitos para gerar a porcentagem?
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidade; //pensar se isso é realmente necessário para a
								  //relação e não apenas uma chave estrangeira
	
	@Column(name = "cursosExtras_vaga", nullable = false)
	private String cursosExtra;
	
	@Column(name = "Conhecimentos_vaga", nullable = false)
	private String conhecimentos;

	@Column(name = "experiencia_vaga", nullable = false)
	private String experiencia;
}
