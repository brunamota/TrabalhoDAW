package net.ufjnet.joppool.services;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.ufjnet.joppool.dtos.EmpresaDTO;
import net.ufjnet.joppool.models.Empresa;
import net.ufjnet.joppool.repositories.EmpresaDAO;
import net.ufjnet.joppool.services.exceptions.BusinessException;

@AllArgsConstructor
@Service
public class GestaoEmpresa {
private EmpresaDAO dao_empresa;
	
	@Transactional(readOnly = true)
	public Page<EmpresaDTO> findAll(Pageable pageable){
		Page<Empresa> result = dao_empresa.findAll(pageable);
		return result.map(obj-> new EmpresaDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findById(Integer id) {
		Empresa result = dao_empresa.findById(id).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new EmpresaDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findByCnpj(String cnpj) {
		Empresa result = dao_empresa.findByCnpj(cnpj).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new EmpresaDTO(result);
		
	}
	
	/*@Transactional(readOnly = true)
	public EmpresaoDTO findByConvenio(String convenio) {
		Empresa result = dao_empresa.findByConvenio(convenio).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new EmpresaDTO(result);
		
		
	}*/
	
	@Transactional(readOnly = true)
	public EmpresaDTO findByNome(String nome) {
		Empresa result = dao_empresa.findByNome(nome).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new EmpresaDTO(result);
		
		
	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findByEmail(String email) {
		Empresa result = dao_empresa.findByEmail(email).
				orElseThrow(()-> new BusinessException("Registro não encontrado"));
		
		return  new EmpresaDTO(result);
	}
	
	@Transactional
	public EmpresaDTO save(@Valid EmpresaDTO obj) {
		Empresa entityEmpresa = new Empresa(obj.getIdEmpresa(), obj.getNome(),obj.getCnpj(),obj.getEmail(),obj.getTelefone(), obj.getEndereco(), obj.getCidade(), obj.getEstado(), obj.getAreaAtuacao());
		
		boolean cpfExists = dao_empresa.findByCnpj(entityEmpresa.getCnpj())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityEmpresa));
		
		if(cpfExists) {
			throw new BusinessException("CPF já cadastrado!");
		}
		
		boolean emailExists = dao_empresa.findByEmail(entityEmpresa.getEmail())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityEmpresa));
		
		if(emailExists) {
			throw new BusinessException("Email já cadastrado!");
		}
		
		/*boolean convenioExists = dao_empresa.findByMatricula(entityEmpresa.getConvenio())
				.stream()
				.anyMatch(objResult -> !objResult.equals(entityEmpresa));
		
		if(convenioExists) {
			throw new BusinessException("Matricula já cadastrado!");
		}*/
		
		
		return new EmpresaDTO(dao_empresa.save(entityEmpresa));
	}
	
	@Transactional
	public void deleteById(Integer id) {
		dao_empresa.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao_empresa.existsById(id);
	}
	
	@Transactional
	public EmpresaDTO update(EmpresaDTO obj) {
		Empresa entity = dao_empresa.findById(obj.getIdEmpresa())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		entity.setNome(obj.getNome());
		entity.setCnpj(obj.getCnpj());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setEndereco(obj.getEndereco());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setAreaAtuacao(obj.getAreaAtuacao());
		
		return new EmpresaDTO(dao_empresa.save(entity));
		
		
	}

}
