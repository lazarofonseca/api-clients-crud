package com.lazaro.api.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lazaro.api.cliente.dto.ClientDTO;
import com.lazaro.api.cliente.entities.Client;
import com.lazaro.api.cliente.repositories.ClientReporitory;

@Service
public class ClientService {
	
	@Autowired
	ClientReporitory clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = clientRepository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	

}
