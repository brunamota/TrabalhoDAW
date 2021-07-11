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

import net.ufjnet.joppool.dtos.CoordenadorDTO;
import net.ufjnet.joppool.services.GestaoCoordenador;

@RestController
@RequestMapping("/v1/jp/coordenadores")
@Tag(name = "Endpoint do Coordenardor") 
public class CoordenadorController {
	
	@Autowired
	private GestaoCoordenador service;
	
	@GetMapping
	@Operation(summary = "Busca todos os coordenardors")
	public ResponseEntity<CollectionModel<CoordenadorDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<CoordenadorDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(c->c.add(
					 linkTo(methodOn(CoordenadorController.class).buscarUm(c.getIdCoordenador())).withSelfRel()
					 )
			);

		return ResponseEntity.ok(CollectionModel.of(pages));
	}
		
	@GetMapping("/{idCoordenador}")
	@Operation(summary = "Busca um coordenardor por id")
	public ResponseEntity<CoordenadorDTO>buscarUm(@PathVariable Integer idCoordenador){
		CoordenadorDTO objDTO = service.findById(idCoordenador);
		objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarUm(idCoordenador)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca um coordenardor por nome")
	public ResponseEntity<CoordenadorDTO> buscarNome(@PathVariable String nome) {
		CoordenadorDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarNome(nome)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}
	
	@GetMapping("/cpf/{cpf}")
	@Operation(summary = "Busca um coordenardor por cpf")
	public ResponseEntity<CoordenadorDTO>buscarCpf(@PathVariable String cpf){
		CoordenadorDTO objDTO = service.findByCPF(cpf);
		objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarCpf(cpf)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	/*
	@GetMapping("/{portaria}")
	public ResponseEntity<CoordenadorDTO>buscarMatricula(@PathVariable String portaria){
		CoordenadorDTO objDTO = service.findByMatricula(portaria);
		objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarMatricula(portaria)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}*/
	
	@GetMapping("/email/{email}")
	@Operation(summary = "Busca um coordenardor por email")
	public ResponseEntity<CoordenadorDTO> buscarEmail(@PathVariable String email) {
		CoordenadorDTO objDTO = service.findByEmail(email);
			objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarEmail(email)).withSelfRel());
			return ResponseEntity.ok(objDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere um novo coordenardor")
	public ResponseEntity<CoordenadorDTO> incluir(@RequestBody CoordenadorDTO objBody){
		CoordenadorDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarUm(objDTO.getIdCoordenador())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um coordenardor por id")
	public ResponseEntity<CoordenadorDTO> atualizar(@RequestBody CoordenadorDTO objBody) {
		CoordenadorDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(CoordenadorController.class).buscarUm(objDTO.getIdCoordenador())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{idCoordenador}")
	@Operation(summary = "Exclui um coordenardor por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer idCoordenador) {
		if (!service.existById(idCoordenador)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(idCoordenador);

		return ResponseEntity.noContent().build();

	}
	
}
