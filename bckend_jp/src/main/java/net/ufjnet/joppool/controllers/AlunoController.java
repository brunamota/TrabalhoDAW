package net.ufjnet.joppool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import net.ufjnet.joppool.dtos.AlunoDTO;
import net.ufjnet.joppool.services.GestaoAluno;

@RestController
@RequestMapping("/v1/jp/alunos")
@Tag(name = "Endpoint do Aluno") 
public class AlunoController {
	
	@Autowired
	private GestaoAluno service;
	
	@GetMapping
	@Operation(summary = "Busca todos os alunos")
	public ResponseEntity<CollectionModel<AlunoDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<AlunoDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(p->p.add(
					 linkTo(methodOn(AlunoController.class).buscarUm(p.getIdAluno())).withSelfRel()
					 )
			);
		return ResponseEntity.ok(CollectionModel.of(pages));
	}

	
	@GetMapping("/{idAluno}")
	@Operation(summary = "Busca um aluno por id")
	public ResponseEntity<AlunoDTO>buscarUm(@PathVariable Integer idAluno){
		AlunoDTO objDTO = service.findById(idAluno);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarUm(idAluno)).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
		
	}
	
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca um aluno por nome")
	public ResponseEntity<AlunoDTO> buscarNome(@PathVariable String nome) {
			AlunoDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(AlunoController.class).buscarNome(nome)).withSelfRel());
			
			return ResponseEntity.ok(objDTO);
		}
	
	
	@GetMapping("/cpf/{cpf}")
	@Operation(summary = "Busca um aluno por cpf")
	public ResponseEntity<AlunoDTO>buscarCpf(@PathVariable String cpf){
		AlunoDTO objDTO = service.findByCpf(cpf);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarCpf(cpf)).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
		
	}
	
	
	@GetMapping("/email/{email}")
	@Operation(summary = "Busca um aluno por email")
	public ResponseEntity<AlunoDTO>buscarEmail(@PathVariable String email){
		AlunoDTO objDTO = service.findByEmail(email);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarEmail(email)).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
		
	}
	
	
	@GetMapping("/matricula/{matricula}")
	@Operation(summary = "Busca um aluno por matricula")
	public ResponseEntity<AlunoDTO>buscarMatricula(@PathVariable String matricula){
		AlunoDTO objDTO = service.findByMatricula(matricula);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarMatricula(matricula)).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere um novo aluno")
	public ResponseEntity<AlunoDTO> incluir(@RequestBody AlunoDTO objBody){
		AlunoDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarUm(objDTO.getIdAluno())).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um aluno por id")
	public ResponseEntity<AlunoDTO> atualizar(@RequestBody AlunoDTO objBody) {
		AlunoDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(AlunoController.class).buscarUm(objDTO.getIdAluno())).withSelfRel());
		
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{idAluno}")
	@Operation(summary = "Exclui um aluno por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer idAluno) {
		if (!service.existById(idAluno)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(idAluno);

		return ResponseEntity.noContent().build();

	}
	
	}
