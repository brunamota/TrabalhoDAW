package net.ufjnet.joppool.repositories;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.joppool.dtos.CoordenadorDTO;
import net.ufjnet.joppool.models.Coordenador;

public interface CoordenadorDAO extends JpaRepository<Coordenador, Integer >{
	public Optional<Coordenador> findByCpf(String cpf);
	public Optional<Coordenador> findByNome(String nome);
	public Optional<Coordenador> findByEmail(String email);
	public Coordenador save(@Valid CoordenadorDTO objBody);
}
