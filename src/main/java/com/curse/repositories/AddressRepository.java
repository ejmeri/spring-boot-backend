package com.curse.repositories;


import com.curse.business.addresses.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "AddressMainRepository")
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
