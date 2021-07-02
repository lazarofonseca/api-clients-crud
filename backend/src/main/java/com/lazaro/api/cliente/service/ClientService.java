package com.lazaro.api.cliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lazaro.api.cliente.dto.ClientDTO;
import com.lazaro.api.cliente.entities.Client;
import com.lazaro.api.cliente.repositories.ClientReporitory;
import com.lazaro.api.cliente.service.exception.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientReporitory clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = clientRepository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClientDTO(client);

	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = clientRepository.save(entity);
		
		return new ClientDTO(entity);

	}

}
