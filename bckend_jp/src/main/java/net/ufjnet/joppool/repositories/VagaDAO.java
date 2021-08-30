package net.ufjnet.joppool.repositories;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.joppool.dtos.VagaDTO;
import net.ufjnet.joppool.models.Vaga;

public interface VagaDAO extends JpaRepository<Vaga, Integer >{
	public Optional<Vaga> findByNome(String nome);
	public Vaga save(@Valid VagaDTO objBody);
	
	//PorcentagemDTO obj = new PorcentagemDTO();
	
	
	//@Query("Select new net.ufjnet.joppool.dtos.PorcentagemDTO(obj.requisito, SUM(obj.porcentagemRequisito)) FROM Habilidade as obj GROUP BY obj.requisito")
	//List<PorcentagemDTO>totalPorcentagem();
}
