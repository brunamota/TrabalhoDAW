package net.ufjnet.joppool.repositories;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ufjnet.joppool.dtos.AlunoDTO;
import net.ufjnet.joppool.models.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Integer >{
	public Optional<Aluno> findByCpf(String cpf);
	public Optional<Aluno> findByNome(String nome);
	public Optional<Aluno> findByEmail(String email);
	public Optional<Aluno> findByMatricula(String matricula);
	public Aluno save(@Valid AlunoDTO objBody);
}
