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
import net.ufjnet.joppool.dtos.VagaDTO;
import net.ufjnet.joppool.services.GestaoVaga;

@RestController
@RequestMapping("/v1/jp/vagas")
@Tag(name = "Endpoint de Vaga") 
public class VagaController {
	@Autowired
	private GestaoVaga service;
	
	@GetMapping
	@Operation(summary = "Busca todas as empresas")
	public ResponseEntity<CollectionModel<VagaDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<VagaDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(v->v.add(
					 linkTo(methodOn(VagaController.class).buscarUm(v.getIdVaga())).withSelfRel()
					 )
			);
		return ResponseEntity.ok(CollectionModel.of(pages));
	}
		
	@GetMapping("/{idVaga}")
	@Operation(summary = "Busca uma empresa por id")
	public ResponseEntity<VagaDTO>buscarUm(@PathVariable Integer idVaga){
		VagaDTO objDTO = service.findById(idVaga);
		objDTO.add(linkTo(methodOn(VagaController.class).buscarUm(idVaga)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca uma empresa por nome")
	public ResponseEntity<VagaDTO> buscarNome(@PathVariable String nome) {
		VagaDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(VagaController.class).buscarNome(nome)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere uma nova empresa")
	public ResponseEntity<VagaDTO> incluir(@RequestBody VagaDTO objBody){
		VagaDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(VagaController.class).buscarUm(objDTO.getIdVaga())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza uma empresa por id")
	public ResponseEntity<VagaDTO> atualizar(@RequestBody VagaDTO objBody) {
		VagaDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(VagaController.class).buscarUm(objDTO.getIdVaga())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{idVaga}")
	@Operation(summary = "Exclui uma empresa por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer idVaga) {
		if (!service.existById(idVaga)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(idVaga);

		return ResponseEntity.noContent().build();

	}
}
