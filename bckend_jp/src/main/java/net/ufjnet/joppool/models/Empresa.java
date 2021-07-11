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
@Table(name = "Empresas")
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_empresa")
	private Integer idEmpresa;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "nome_empresa", nullable = false)
	private String nome;
	
	@Size(max=18)//XX.XXX.XXX/0001-XX
	@NotBlank
	@Column(name = "cnpj_empresa", nullable = false)
	private String cnpj;
	
	@Email
	@NotBlank
	@Column(name = "email_empresa", nullable = false)
	private String email;
	
	@Size(max=14)//(00)00000-0000
	@NotBlank
	@Column(name = "telefone_empresa", nullable = false)
	private String telefone;
	
	@Size(max=30)
	@NotBlank
	@Column(name = "enderaco_empresa", nullable = false)
	private String endereco;
	
	@Size(max=30)
	@NotBlank
	@Column(name = "cidade_empresa", nullable = false)
	private String cidade;
	
	@Size(max=2)//sigla
	@NotBlank
	@Column(name = "estado_empresa", nullable = false)
	private String estado;
	
	@Size(max=60)
	@NotBlank
	@Column(name = "areaAtuacao_empresa", nullable = false)
	private String areaAtuacao;
	
	//talvez ser um auto incremento para gerar o numero de convenio com a UFJ que será gerado após a aprovação do professor, pensar como essa relação deve existir
	//@Column(name = "numeroConvenio_aluno", nullable = false)
	//private String Convenio;

}
