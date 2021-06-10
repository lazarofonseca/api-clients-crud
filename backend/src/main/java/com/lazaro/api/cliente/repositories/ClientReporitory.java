package com.lazaro.api.cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.api.cliente.entities.Client;

@Repository
public interface ClientReporitory extends JpaRepository<Client, Long>{

}
