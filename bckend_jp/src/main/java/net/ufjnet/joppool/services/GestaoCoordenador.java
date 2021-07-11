package net.ufjnet.joppool.services;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.CoordenadorDTO;
import net.ufjnet.joppool.exceptions.BusinessException;
import net.ufjnet.joppool.models.Coordenador;
import net.ufjnet.joppool.repositories.CoordenadorDAO;

@AllArgsConstructor
@Service
public class GestaoCoordenador {
	
	private CoordenadorDAO dao_coordenador;
	
	@Transactional(readOnly = true)
	public Page<CoordenadorDTO> findAll(Pageable pageable){
		Page<Coordenador> result = dao_coordenador.findAll(pageable);
		return result.map(obj-> new CoordenadorDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public CoordenadorDTO findById(Integer id) {
		Coordenador result = dao_coordenador.findById(id).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new CoordenadorDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public CoordenadorDTO findByCPF(String cpf) {
		Coordenador result = dao_coordenador.findByCpf(cpf).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new CoordenadorDTO(result);
		
	}
	
	/*@Transactional(readOnly = true)
	public CoordenadorDTO findByMatricula(Integer portaria) {
		Coordenador result = dao_coordenador.findByPortaria(portaria).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new CoordenadorDTO(result);
		
		
	}*/
	
	@Transactional(readOnly = true)
	public CoordenadorDTO findByNome(String nome) {
		Coordenador result = dao_coordenador.findByNome(nome).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new CoordenadorDTO(result);
		
		
	}
	
	@Transactional(readOnly = true)
	public CoordenadorDTO findByEmail(String email) {
		Coordenador result = dao_coordenador.findByEmail(email).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new CoordenadorDTO(result);
	}
	
	@Transactional
	public CoordenadorDTO save(@Valid CoordenadorDTO obj) {
		Coordenador entityCoordenador = new Coordenador(obj.getIdCoordenador(),obj.getNome(), obj.getCpf(),obj.getEmail(),obj.getTelefone(),obj.getEndereco(), obj.getCidade(), obj.getEstado(), obj.getInstituicao(), obj.getCurso(), obj.getPortaria());
		
		boolean cpfExists = dao_coordenador.findByCpf(entityCoordenador.getCpf())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityCoordenador));
		
		if(cpfExists) {
			throw new BusinessException("CPF já cadastrado!");
		}
		
		boolean emailExists = dao_coordenador.findByEmail(entityCoordenador.getEmail())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityCoordenador));
		
		if(emailExists) {
			throw new BusinessException("Email já cadastrado!");
		}
		/*
		boolean portariaExists = dao_coordenador.findByPortaria(entityCoordenador.getPortaria())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityCoordenador));
		
		if(portariaExists) {
			throw new BusinessException("Portaria já cadastrada!");
		}*/
		
		
		return new CoordenadorDTO(dao_coordenador.save(entityCoordenador));
	}
	
	@Transactional
	public void deleteById(Integer id) {
		dao_coordenador.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao_coordenador.existsById(id);
	}
	
	@Transactional
	public CoordenadorDTO update(CoordenadorDTO obj) {
		Coordenador entity = dao_coordenador.findById(obj.getIdCoordenador())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setInstituicao(obj.getInstituicao());
		entity.setCurso(obj.getCurso());
		entity.setPortaria(obj.getPortaria());
		
		
		return new CoordenadorDTO(dao_coordenador.save(entity));
		
		
	}

}
