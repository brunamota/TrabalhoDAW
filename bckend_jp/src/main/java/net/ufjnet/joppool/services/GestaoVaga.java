package net.ufjnet.joppool.services;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.VagaDTO;
import net.ufjnet.joppool.exceptions.BusinessException;
import net.ufjnet.joppool.models.Vaga;
import net.ufjnet.joppool.repositories.VagaDAO;

@AllArgsConstructor
@Service
public class GestaoVaga {
	private VagaDAO dao_vaga;
	
	@Transactional(readOnly = true)
	public Page<VagaDTO> findAll(Pageable pageable){
		Page<Vaga> result = dao_vaga.findAll(pageable);
		return result.map(obj-> new VagaDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public VagaDTO findById(Integer id) {
		Vaga result = dao_vaga.findById(id).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new VagaDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public VagaDTO findByNome(String nome) {
		Vaga result = dao_vaga.findByNome(nome).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new VagaDTO(result);		
		
	}
	
	
	@Transactional
	public VagaDTO save(@Valid VagaDTO obj) {
		Vaga entityVaga = new Vaga(obj.getIdVaga(), obj.getNome(), obj.getQuantidade(), obj.getPorcentagem(),obj.getRemuneracao(), obj.getRequisitos(), obj.getAtividades(),obj.getHorasSemanais(), obj.getPeriodoDia());
		
		boolean nomeExists = dao_vaga.findByNome(entityVaga.getNome())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityVaga));
		
		if(nomeExists) {
			throw new BusinessException("Nome já cadastrado!");
		}
		
		return new VagaDTO(dao_vaga.save(entityVaga));
	}
	
	@Transactional
	public void deleteById(Integer id) {
		dao_vaga.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao_vaga.existsById(id);
	}
	
	@Transactional
	public VagaDTO update(VagaDTO obj) {
		Vaga entity = dao_vaga.findById(obj.getIdVaga())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		entity.setNome(obj.getNome());
		
		
		
		return new VagaDTO(dao_vaga.save(entity));
		
		
	}

}
