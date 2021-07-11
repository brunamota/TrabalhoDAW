package net.ufjnet.joppool.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
import net.ufjnet.joppool.dtos.EmpresaDTO;
import net.ufjnet.joppool.services.GestaoEmpresa;

@RestController
@RequestMapping("/v1/jp/empresas")
@Tag(name = "Endpoint de Empresa") 
public class EmpresaController {
	
	@Autowired
	private GestaoEmpresa service;
	
	@GetMapping
	@Operation(summary = "Busca todas as empresas")
	public ResponseEntity<CollectionModel<EmpresaDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<EmpresaDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(e->e.add(
					 linkTo(methodOn(EmpresaController.class).buscarUm(e.getIdEmpresa())).withSelfRel()
					 )
			);
		return ResponseEntity.ok(CollectionModel.of(pages));
	}
		
	@GetMapping("/{idEmpresa}")
	@Operation(summary = "Busca uma empresa por id")
	public ResponseEntity<EmpresaDTO>buscarUm(@PathVariable Integer idEmpresa){
		EmpresaDTO objDTO = service.findById(idEmpresa);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(idEmpresa)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca uma empresa por nome")
	public ResponseEntity<EmpresaDTO> buscarNome(@PathVariable String nome) {
		EmpresaDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(EmpresaController.class).buscarNome(nome)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}
	
	@GetMapping("/cnpj/{cnpj}")
	@Operation(summary = "Busca uma empresa por CNPJ")
	public ResponseEntity<EmpresaDTO>buscarCpf(@PathVariable String cnpj){
		EmpresaDTO objDTO = service.findByCnpj(cnpj);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarCpf(cnpj)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	/*
	@GetMapping("/{convenio}")
	public ResponseEntity<EmpresaDTO>buscarMatricula(@PathVariable String convenio){
		EmpresaDTO objDTO = service.findByMatricula(convenio);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarMatricula(convenio)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}*/
	
	@GetMapping("/email/{email}")
	@Operation(summary = "Busca uma empresa por email")
	public ResponseEntity<EmpresaDTO> buscarEmail(@PathVariable String email) {
		EmpresaDTO objDTO = service.findByEmail(email);
			objDTO.add(linkTo(methodOn(EmpresaController.class).buscarEmail(email)).withSelfRel());
			return ResponseEntity.ok(objDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere uma nova empresa")
	public ResponseEntity<EmpresaDTO> incluir(@RequestBody EmpresaDTO objBody){
		EmpresaDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(objDTO.getIdEmpresa())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza uma empresa por id")
	public ResponseEntity<EmpresaDTO> atualizar(@RequestBody EmpresaDTO objBody) {
		EmpresaDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(objDTO.getIdEmpresa())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{idEmpresa}")
	@Operation(summary = "Exclui uma empresa por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer idEmpresa) {
		if (!service.existById(idEmpresa)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(idEmpresa);

		return ResponseEntity.noContent().build();

	}

}
