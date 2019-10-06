package com.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curse.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
