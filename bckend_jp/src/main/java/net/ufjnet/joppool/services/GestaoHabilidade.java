package net.ufjnet.joppool.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.HabilidadeDTO;
import net.ufjnet.joppool.exceptions.BusinessException;
import net.ufjnet.joppool.models.Habilidade;
import net.ufjnet.joppool.repositories.HabilidadeDAO;

@AllArgsConstructor
@Service
public class GestaoHabilidade {
	
	private HabilidadeDAO dao_habilidade;
	
	
	@Transactional(readOnly = true)
	public Page<HabilidadeDTO> findAll(Pageable pageable){
		Page<Habilidade> result = dao_habilidade.findAll(pageable);
		return result.map(obj-> new HabilidadeDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public HabilidadeDTO findById(Integer id) {
		Habilidade result = dao_habilidade.findById(id).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new HabilidadeDTO(result);
		
	}	
	
	@Transactional
	public HabilidadeDTO save(HabilidadeDTO obj) {
		Habilidade entityHabilidade = new Habilidade(obj.getIdHabilidade(), obj.getConhecimentos());
		
		return new HabilidadeDTO(dao_habilidade.save(entityHabilidade));
	}
	
	@Transactional
	public void deleteById(Integer idHabilidade) {
		dao_habilidade.deleteById(idHabilidade);
	}
	
	public boolean existById(Integer idHabilidade) {
		return dao_habilidade.existsById(idHabilidade);
	}
	
	@Transactional
	public HabilidadeDTO update(HabilidadeDTO obj) {
		Habilidade entity = dao_habilidade.findById(obj.getIdHabilidade())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		entity.setConhecimentos(obj.getConhecimentos());
		
	
		return new HabilidadeDTO(dao_habilidade.save(entity));
		
		
	}

}
