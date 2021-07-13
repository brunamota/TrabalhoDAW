package net.ufjnet.joppool.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;

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
import net.ufjnet.joppool.dtos.HabilidadeDTO;
import net.ufjnet.joppool.services.GestaoHabilidade;

@RestController
@RequestMapping("/v1/jp/habilidades")
@Tag(name = "Endpoint de Habilidade") 
public class HabilidadeController {
	
	@Autowired
	private GestaoHabilidade service;

	@GetMapping
	@Operation(summary = "Busca todas as habilidades")
	public ResponseEntity<CollectionModel<HabilidadeDTO>> buscarTodos(
			@RequestParam(value ="page", defaultValue ="0") int page,
			@RequestParam(value ="limit", defaultValue ="12") int limit,
			@RequestParam(value ="direction", defaultValue ="asc") String direction){
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<HabilidadeDTO> pages = service.findAll(pageable);		
		
		pages.stream()
			 .forEach(h->h.add(
					 linkTo(methodOn(HabilidadeController.class).buscarUm(h.getIdHabilidade())).withSelfRel()
					 )
			);
		return ResponseEntity.ok(CollectionModel.of(pages));
	}
	
	@GetMapping("/{idHabilidade}")
	@Operation(summary = "Busca uma habilidade por id")
	public ResponseEntity<HabilidadeDTO>buscarUm(@PathVariable Integer idHabilidade){
		HabilidadeDTO objDTO = service.findById(idHabilidade);
		objDTO.add(linkTo(methodOn(HabilidadeController.class).buscarUm(idHabilidade)).withSelfRel());
		return ResponseEntity.ok(objDTO);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere uma nova habilidade")
	public ResponseEntity<HabilidadeDTO> incluir(@RequestBody @Valid HabilidadeDTO objBody){
		HabilidadeDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(HabilidadeController.class).buscarUm(objDTO.getIdHabilidade())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@PutMapping
	@Operation(summary = "Atualiza uma habilidade por id")
	public ResponseEntity<HabilidadeDTO> atualizar(@RequestBody HabilidadeDTO objBody) {
		HabilidadeDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(HabilidadeController.class).buscarUm(objDTO.getIdHabilidade())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}
	
	@DeleteMapping("/{idHabilidade}")
	@Operation(summary = "Exclui uma habilidade por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer idHabilidade) {
		if (!service.existById(idHabilidade)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(idHabilidade);

		return ResponseEntity.noContent().build();

	}
}
