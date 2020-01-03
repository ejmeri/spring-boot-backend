package com.curse.business.clientes.control;

import com.curse.business.clientes.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    // Transaction readOnly true deixa mais rápido e preserva os locks do banco
    @Transactional(readOnly = true)
    // findByEmail -> sprindata automaticamente reconhece o campo Email como filtro por esta nomenclatura
    Client findByEmail(String email);
}
