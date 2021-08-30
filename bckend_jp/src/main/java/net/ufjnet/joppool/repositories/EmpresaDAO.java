package net.ufjnet.joppool.repositories;

import java.util.Optional;


import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.joppool.dtos.EmpresaDTO;
import net.ufjnet.joppool.models.Empresa;


public interface EmpresaDAO extends JpaRepository<Empresa, Integer >{
	
	public Optional<Empresa> findByCnpj(String cnpj);
	public Optional<Empresa> findByNome(String nome);
	public Optional<Empresa> findByEmail(String email);
	public Empresa save(@Valid EmpresaDTO objBody);
	//ver como compara string para isso funcionar
	
}
