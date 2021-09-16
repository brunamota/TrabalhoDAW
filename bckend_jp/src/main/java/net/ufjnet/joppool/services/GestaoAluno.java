package net.ufjnet.joppool.services;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.AlunoDTO;
import net.ufjnet.joppool.models.Aluno;
import net.ufjnet.joppool.repositories.AlunoDAO;
import net.ufjnet.joppool.services.exceptions.BusinessException;

@AllArgsConstructor
@Service
public class GestaoAluno {
	
	private AlunoDAO dao_aluno;
	
	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAll(Pageable pageable){
		Page<Aluno> result = dao_aluno.findAll(pageable);
		return result.map(obj-> new AlunoDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findById(Integer id) {
		Aluno result = dao_aluno.findById(id).
				orElseThrow(()-> new BusinessException("ID não encontrado"));
		
		return  new AlunoDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findByCpf(String cpf) {
		Aluno result = dao_aluno.findByCpf(cpf).
				orElseThrow(()-> new BusinessException("CPF não encontrado"));
		
		return  new AlunoDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findByMatricula(String matricula) {
		Aluno result = dao_aluno.findByMatricula(matricula).
				orElseThrow(()-> new BusinessException("Matrícula não encontrada"));
		
		return  new AlunoDTO(result);
		
		
	}
	@Transactional(readOnly = true)
	public AlunoDTO findByNome(String nome) {
		Aluno result = dao_aluno.findByNome(nome).
				orElseThrow(()-> new BusinessException("Nome não encontrado"));
		
		return  new AlunoDTO(result);
		
		
	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findByEmail(String email) {
		Aluno result = dao_aluno.findByEmail(email).
				orElseThrow(()-> new BusinessException("E-mail não encontrado"));
		
		return  new AlunoDTO(result);
	}
	
	@Transactional
	public AlunoDTO save(@Valid AlunoDTO obj) {
		Aluno entityAluno = new Aluno(obj.getIdAluno(), obj.getNome(),obj.getCpf(),obj.getEmail(), obj.getDataNascimento(), obj.getTelefone(), obj.getEndereco(), obj.getCidade(), obj.getEstado(), obj.getInstituicao(), obj.getCurso(), obj.getMatricula(), obj.getMatricula());
		
		boolean cpfExists = dao_aluno.findByCpf(entityAluno.getCpf())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityAluno));
		
		if(cpfExists) {
			throw new BusinessException("CPF já cadastrado!");
		}
		
		boolean emailExists = dao_aluno.findByEmail(entityAluno.getEmail())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityAluno));
		
		if(emailExists) {
			throw new BusinessException("Email já cadastrado!");
		}
		
		boolean matriculaExists = dao_aluno.findByMatricula(entityAluno.getMatricula())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityAluno));
		
		if(matriculaExists) {
			throw new BusinessException("Matricula já cadastrado!");
		}
		
		
		return new AlunoDTO(dao_aluno.save(entityAluno));
	}
	
	@Transactional
	public void deleteById(Integer id) {
		dao_aluno.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao_aluno.existsById(id);
	}
	
	@Transactional
	public AlunoDTO update(AlunoDTO obj) {
		Aluno entity = dao_aluno.findById(obj.getIdAluno())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setInstituicao(obj.getInstituicao());
		entity.setCurso(obj.getCurso());
		entity.setMatricula(obj.getMatricula());
		entity.setPeriodo(obj.getPeriodo());
		
		return new AlunoDTO(dao_aluno.save(entity));
		
		
	}

}
