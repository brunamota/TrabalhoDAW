package net.ufjnet.joppool.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.HabilidadeDTO;
import net.ufjnet.joppool.exceptions.BusinessException;
import net.ufjnet.joppool.models.Aluno;
import net.ufjnet.joppool.models.Habilidade;
import net.ufjnet.joppool.repositories.AlunoDAO;
import net.ufjnet.joppool.repositories.HabilidadeDAO;

@AllArgsConstructor
@Service
public class GestaoHabilidade {
	
	private HabilidadeDAO dao_habilidade;
	
	private AlunoDAO dao_aluno;
	
	
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
		Habilidade entityHabilidade = new Habilidade(obj.getIdHabilidade(), obj.getCursosExtra(), obj.getConhecimentos(), obj.getExperiencia(),
				new Aluno(obj.getAluno().getIdAluno(), obj.getAluno().getNome(),
						obj.getAluno().getCpf(), obj.getAluno().getEmail(),obj.getAluno().getDataNascimento(),
						obj.getAluno().getTelefone(), obj.getAluno().getEndereco(),
						obj.getAluno().getCidade(),obj.getAluno().getEstado(),
						obj.getAluno().getInstituicao(), obj.getAluno().getCurso(), obj.getAluno().getMatricula(),
						obj.getAluno().getPeriodo()));


		Optional<Aluno> Aluno = dao_aluno.findById(obj.getAluno().getIdAluno());
		
		entityHabilidade.setAluno(Aluno.orElse(null));
		
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
		
		entity.setExperiencia(obj.getExperiencia());
		
	
		return new HabilidadeDTO(dao_habilidade.save(entity));
		
		
	}

}
