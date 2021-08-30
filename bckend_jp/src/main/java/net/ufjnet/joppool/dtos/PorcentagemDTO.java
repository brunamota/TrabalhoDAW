package net.ufjnet.joppool.dtos;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true,  callSuper = false)
public class PorcentagemDTO  extends RepresentationModel<PorcentagemDTO> implements Serializable {

private static final long serialVersionUID = 1L;
	
	private String requisitosTotal;
	
	private Double porcentagemRequisito;
	
	/*public PorcentagemDTO(Vaga obj, double porcentagemRequisitos) {
		//this.requisitosTotal = obj.getRequisitos();
		this.porcentagemRequisito = porcentagemRequisito;
	}*/
}
