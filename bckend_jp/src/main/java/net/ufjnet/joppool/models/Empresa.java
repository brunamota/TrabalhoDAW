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
@Table(name = "Empresas")
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_empresa")
	private Integer idEmpresa;
	
	
	@Column(name = "nome_empresa", nullable = false)
	private String nome;
	
	
	@Column(name = "cnpj_empresa", nullable = false)
	private String cnpj;
	

	@Column(name = "email_empresa", nullable = false)
	private String email;
	
	
	@Column(name = "telefone_empresa", nullable = false)
	private String telefone;
	
	
	@Column(name = "enderaco_empresa", nullable = false)
	private String endereco;

	@Column(name = "cidade_empresa", nullable = false)
	private String cidade;

	@Column(name = "estado_empresa", nullable = false)
	private String estado;

	@Column(name = "areaAtuacao_empresa", nullable = false)
	private String areaAtuacao;
	
	@OneToMany(mappedBy = "empresa")
	private List<Vaga>vagas = new ArrayList<>();

	public Empresa(Integer idEmpresa, String nome,  String cnpj,String email, String telefone,
			String endereco,String cidade,String estado, String areaAtuacao) {
		this.idEmpresa = idEmpresa;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.areaAtuacao = areaAtuacao;
	}
	
	
	
	//talvez ser um auto incremento para gerar o numero de convenio com a UFJ que será gerado após a aprovação do professor, pensar como essa relação deve existir
	//@Column(name = "numeroConvenio_aluno", nullable = false)
	//private String Convenio;

}
