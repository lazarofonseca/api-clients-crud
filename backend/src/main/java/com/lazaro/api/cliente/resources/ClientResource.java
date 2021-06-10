package com.lazaro.api.cliente.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lazaro.api.cliente.dto.ClientDTO;
import com.lazaro.api.cliente.service.ClientService;



@RestController
@RequestMapping(value = "/clienties")
public class ClientResource{
	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	ClientService clientService;

	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ClientDTO> list = clientService.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
		
	}
	

}